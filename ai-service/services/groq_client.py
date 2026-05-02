import os
import time
import logging

from groq import Groq
from dotenv import load_dotenv

# Load environment variables
load_dotenv()

# Configure logging
logging.basicConfig(level=logging.INFO)

class GroqClient:

    def __init__(self):

        self.api_key = os.getenv("GROQ_API_KEY")

        if not self.api_key:
            raise ValueError("GROQ_API_KEY not found in environment variables")

        self.client = Groq(api_key=self.api_key)

    def generate_response(self, prompt):

        retries = 3
        delay = 2

        for attempt in range(retries):

            try:

                logging.info(f"Attempt {attempt + 1} to call Groq API")

                response = self.client.chat.completions.create(
                    model="llama-3.3-70b-versatile",
                    messages=[
                        {
                            "role": "user",
                            "content": prompt
                        }
                    ],
                    temperature=0.3,
                    max_tokens=500
                )

                output = response.choices[0].message.content

                logging.info("Groq API call successful")

                return output

            except Exception as error:

                logging.error(f"Groq API failed: {error}")

                if attempt < retries - 1:

                    logging.info(f"Retrying in {delay} seconds...")

                    time.sleep(delay)

                    delay *= 2

                else:

                    logging.error("All retry attempts failed")

                    return None