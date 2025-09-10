import React, { useEffect, useState } from "react";
import { getAllPersons } from "./api";

function PersonTable({ refresh }) {
    const [persons, setPersons] = useState([]);

    useEffect(() => {
        getAllPersons().then(setPersons);
    }, [refresh]);

    return (
        <table border="1" cellPadding="8" cellSpacing="0" style={{ width: "100%" }}>
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Age</th>
                <th>Aadhar Number</th>
                <th>Address</th>
            </tr>
            </thead>
            <tbody>
            {persons.map((p) => (
                <tr key={p.id}>
                    <td>{p.id}</td>
                    <td>{p.name}</td>
                    <td>{p.age}</td>
                    <td>{p.aadhar?.aadharNumber}</td>
                    <td>{p.aadhar?.address}</td>
                </tr>
            ))}
            </tbody>
        </table>
    );
}

export default PersonTable;
