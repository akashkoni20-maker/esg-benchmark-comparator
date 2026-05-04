from flask import Blueprint, request, jsonify

from services.groq_client import GroqClient
from middleware.security_middleware import validate_request

ai_bp = Blueprint("ai_bp", __name__)

groq_client = GroqClient()


@ai_bp.route("/generate", methods=["POST"])
def generate():
    data = request.get_json()

    if not data or "prompt" not in data:
        return {"error": "Invalid input"}, 400

    prompt = data.get("prompt")

    # Prompt injection protection
    if any(x in prompt.lower() for x in [
        "ignore previous instructions",
        "system prompt",
        "reveal",
        "bypass"
    ]):
        return {"error": "Prompt injection detected"}, 400

    try:
        response = groq_client.generate_response(prompt)
        return {"response": response}, 200
    except Exception:
        return {"error": "AI service failed"}, 500
