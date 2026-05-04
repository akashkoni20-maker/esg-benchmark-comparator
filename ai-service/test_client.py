from services.groq_client import GroqClient

client = GroqClient()

prompt = "Explain ESG benchmarking in simple terms."

response = client.generate_response(prompt)

print("\nAI RESPONSE:\n")

print(response)