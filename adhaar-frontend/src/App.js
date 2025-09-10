import React, { useState } from "react";
import PersonForm from "./PersonForm";
import PersonTable from "./PersonTable";

function App() {
    const [refresh, setRefresh] = useState(false);

    return (
        <div style={{ padding: "20px" }}>
            <h1>Aadhaar Management System</h1>
            <PersonForm onPersonAdded={() => setRefresh(!refresh)} />
            <PersonTable refresh={refresh} />
        </div>
    );
}

export default App;
