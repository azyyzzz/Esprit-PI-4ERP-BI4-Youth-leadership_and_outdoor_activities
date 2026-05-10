import json
from datetime import datetime
import os

file_path = 'PowerBIPerformanceData.json'

with open(file_path, 'r', encoding='utf-8-sig') as f:
    data = json.load(f)

events = data.get('events', [])

# Visuals
visuals = []
queries = []

def get_duration_ms(start_str, end_str):
    if not start_str or not end_str:
        return 0
    try:
        start = datetime.strptime(start_str.replace('Z', '+0000'), '%Y-%m-%dT%H:%M:%S.%f%z')
        end = datetime.strptime(end_str.replace('Z', '+0000'), '%Y-%m-%dT%H:%M:%S.%f%z')
        return (end - start).total_seconds() * 1000
    except Exception as e:
        return 0

for e in events:
    name = e.get('name')
    if name == 'Visual Container Lifecycle':
        metrics = e.get('metrics', {})
        v_title = metrics.get('visualTitle', 'Unknown Visual')
        v_type = metrics.get('visualType', 'Unknown Type')
        duration = get_duration_ms(e.get('start'), e.get('end'))
        visuals.append({
            'title': v_title,
            'type': v_type,
            'duration_ms': duration
        })
    elif name == 'Execute DAX Query':
        metrics = e.get('metrics', {})
        q_text = metrics.get('QueryText', '')
        duration = get_duration_ms(e.get('start'), e.get('end'))
        queries.append({
            'query_text': q_text,
            'duration_ms': duration
        })

with open("output_report.txt", "w", encoding='utf-8') as out:
    out.write("================ SLOWEST VISUALS ================\n")
    visual_aggs = {}
    for v in visuals:
        k = f"{v['title']} ({v['type']})"
        if k not in visual_aggs:
            visual_aggs[k] = []
        visual_aggs[k].append(v['duration_ms'])

    sorted_visuals = sorted(visual_aggs.items(), key=lambda x: max(x[1]), reverse=True)
    for i, (k, durations) in enumerate(sorted_visuals[:10]):
        out.write(f"{i+1}. {k}: Max {max(durations):.1f} ms, Avg {(sum(durations)/len(durations)):.1f} ms, Count {len(durations)}\n")


    out.write("\n================ SLOWEST DAX QUERIES ================\n")
    query_aggs = {}
    for q in queries:
        k = q['query_text'].replace('\n', ' ')
        if len(k) > 100:
            k = k[:100] + "..."
        if k not in query_aggs:
            query_aggs[k] = []
        query_aggs[k].append(q['duration_ms'])

    sorted_queries = sorted(query_aggs.items(), key=lambda x: max(x[1]), reverse=True)
    for i, (k, durations) in enumerate(sorted_queries[:10]):
        out.write(f"{i+1}. Dauer Max {max(durations):.1f} ms, Count {len(durations)}\n")
        out.write(f"   Query Extract: {k}\n")
