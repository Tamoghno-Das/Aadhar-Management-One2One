import React, { useState } from "react";
import { createPerson } from "./api";

function PersonForm({ onPersonAdded }) {
    const [form, setForm] = useState({
        name: "",
        age: "",
        aadharNumber: "",
        address: ""
    });

    const handleChange = (e) => {
        setForm({ ...form, [e.target.name]: e.target.value });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        const person = {
            name: form.name,
            age: parseInt(form.age),
            aadhar: {
                aadharNumber: form.aadharNumber,
                address: form.address,
            },
        };
        await createPerson(person);
        onPersonAdded();
        setForm({ name: "", age: "", aadharNumber: "", address: "" });
    };

    return (
        <form onSubmit={handleSubmit} style={styles.form}>
            <h2>Add Person</h2>
            <input
                type="text"
                name="name"
                placeholder="Name"
                value={form.name}
                onChange={handleChange}
                style={styles.input}
            />
            <input
                type="number"
                name="age"
                placeholder="Age"
                value={form.age}
                onChange={handleChange}
                style={styles.input}
            />
            <input
                type="text"
                name="aadharNumber"
                placeholder="Aadhar Number"
                value={form.aadharNumber}
                onChange={handleChange}
                style={styles.input}
            />
            <input
                type="text"
                name="address"
                placeholder="Address"
                value={form.address}
                onChange={handleChange}
                style={styles.input}
            />
            <button type="submit" style={styles.button}>Save</button>
        </form>
    );
}

const styles = {
    form: { marginBottom: "20px", padding: "10px", border: "1px solid #ccc" },
    input: { display: "block", margin: "10px 0", padding: "8px", width: "100%" },
    button: { padding: "8px 16px", background: "blue", color: "white", border: "none" }
};

export default PersonForm;
