const API_URL = "http://localhost:8888/api/person";

export async function createPerson(person) {
    const response = await fetch(API_URL, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(person),
    });
    return response.json();
}

export async function getAllPersons() {
    const response = await fetch(API_URL);
    return response.json();
}
