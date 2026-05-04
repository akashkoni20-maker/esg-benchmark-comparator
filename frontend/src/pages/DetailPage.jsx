import { useParams } from "react-router-dom";

function DetailPage() {
  const { id } = useParams();

  const score = 88;

  return (
    <div style={{ padding: "20px" }}>
      <h2>Detail Page ID: {id}</h2>

      <p>
        Score:
        <span style={{
          background: "green",
          color: "white",
          padding: "5px",
          marginLeft: "10px"
        }}>
          {score}
        </span>
      </p>

      <button>Edit</button>
      <button style={{ marginLeft: "10px" }}>Delete</button>
    </div>
  );
}

export default DetailPage;