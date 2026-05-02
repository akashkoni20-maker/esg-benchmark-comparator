from flask import Flask
from flask_limiter import Limiter
from flask_limiter.util import get_remote_address

app = Flask(__name__)

# Configure rate limiter
limiter = Limiter(
    key_func=get_remote_address,
    default_limits=["30 per minute"]
)

limiter.init_app(app)

@app.route("/health")
def health():
    return {
        "status": "healthy",
        "message": "AI Service Running"
    }

if __name__ == "__main__":
    app.run(debug=True, port=5000)