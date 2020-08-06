async function getStudentById(id) {
    fetch(`/api/student/read/${id}`)
        .then(result => result.json())
        .then(student => {
            document.getElementById("stud_id").append(student.username);
            document.getElementById("stud_name").append(student.firstName + " " + student.lastName);
            document.getElementById("stud_birth_date").append(student.birthDate);
            document.getElementById("stud_ent").append(student.entBall);
            document.getElementById("stud_email").append(student.email);
            document.getElementById("stud_faculty").append(student.faculty.name);
        })
}

let studentId = document.getElementById("studentId").dataset.studentId;
getStudentById(studentId)


