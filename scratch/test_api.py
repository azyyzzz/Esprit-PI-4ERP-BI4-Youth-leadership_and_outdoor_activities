import requests
import json

url = "http://127.0.0.1:8005/predict"
data = {
    "Nb_Membres": 10.0,
    "Nb_Chefs": 2.0,
    "Participation_Rate": 0.8
}

response = requests.post(url, json=data)
print(f"Status Code: {response.status_code}")
print(f"Response: {json.dumps(response.json(), indent=2)}")

metrics_url = "http://127.0.0.1:8005/metrics"
metrics_resp = requests.get(metrics_url)
print("\nMetrics Snippet:")
print("\n".join(metrics_resp.text.splitlines()[:10]))
