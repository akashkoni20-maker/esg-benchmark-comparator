from flask import Blueprint, request, jsonify

from services.groq_client import GroqClient
from middleware.security_middleware import validate_request

describe_bp = Blueprint("describe_bp", __name__)

groq_client = GroqClient()


@describe_bp.route("/describe", methods=["POST"])
def describe():

    validation_error = validate_request()

    if validation_error:
        return validation_error

    prompt = request.sanitized_prompt

    final_prompt = f"""
    Analyze the following ESG benchmark data and provide a concise description:

    {prompt}
    """

    response = groq_client.generate_response(final_prompt)

    if not response:
        return jsonify({
            "error": "Failed to generate description"
        }), 500

    return jsonify({
        "success": True,
        "description": response
    })