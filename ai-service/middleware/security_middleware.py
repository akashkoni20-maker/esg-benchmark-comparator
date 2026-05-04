import re
import bleach
from flask import request, jsonify

# Common prompt injection patterns
SUSPICIOUS_PATTERNS = [
    r"ignore previous instructions",
    r"system prompt",
    r"bypass security",
    r"developer mode",
    r"jailbreak",
    r"<script>",
    r"</script>",
]

def sanitize_input(text):

    if not text:
        return ""

    cleaned_text = bleach.clean(text)

    return cleaned_text.strip()


def detect_prompt_injection(text):

    text = text.lower()

    for pattern in SUSPICIOUS_PATTERNS:

        if re.search(pattern, text):
            return True

    return False


def validate_request():

    data = request.get_json()

    if not data:
        return jsonify({
            "error": "Invalid JSON payload"
        }), 400

    prompt = data.get("prompt", "")

    sanitized_prompt = sanitize_input(prompt)

    if detect_prompt_injection(sanitized_prompt):

        return jsonify({
            "error": "Prompt injection detected"
        }), 400

    request.sanitized_prompt = sanitized_prompt

    return None