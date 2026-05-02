import os
from groq import Groq
from dotenv import load_dotenv

# Load environment variables
load_dotenv()

# Get API key
api_key = os.getenv("GROQ_API_KEY")

if not api_key:
    raise ValueError("GROQ_API_KEY not found in .env file")

# Initialize Groq client
client = Groq(api_key=api_key)

try:
    print("Connecting to Groq API...\n")

    response = client.chat.completions.create(
        model="llama-3.3-70b-versatile",
        messages=[
            {
                "role": "user",
                "content": "Explain ESG benchmarking in 3 lines."
            }
        ],
        temperature=0.3,
        max_tokens=100
    )

    output = response.choices[0].message.content

    print("Groq API Connected Successfully!\n")
    print("AI Response:\n")
    print(output)

except Exception as error:
    print("Error connecting to Groq API")
    print(f"Details: {error}")