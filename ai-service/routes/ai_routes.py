from flask import Blueprint, request, jsonify

from services.groq_client import GroqClient
from middleware.security_middleware import validate_request

ai_bp = Blueprint("ai_bp", __name__)

groq_client = GroqClient()


@ai_bp.route("/generate", methods=["POST"])
def generate_response():

    validation_error = validate_request()

    if validation_error:
        return validation_error

    prompt = request.sanitized_prompt

    response = groq_client.generate_response(prompt)

    if not response:
        return jsonify({
            "error": "Failed to generate AI response"
        }), 500

    return jsonify({
        "success": True,
        "response": response
    })