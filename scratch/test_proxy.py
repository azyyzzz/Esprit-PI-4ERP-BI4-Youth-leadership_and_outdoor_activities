import requests
import json

url = "http://127.0.0.1:5001/mlops/predict"
data = {
    "Nb_Membres": 10.0,
    "Nb_Chefs": 2.0,
    "Participation_Rate": 0.8
}

try:
    response = requests.post(url, json=data)
    print(f"Status Code: {response.status_code}")
    print(f"Response: {json.dumps(response.json(), indent=2)}")
except Exception as e:
    print(f"Error: {e}")
