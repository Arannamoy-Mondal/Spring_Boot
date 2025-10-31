<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Job</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand fw-bold" href="home">Job Portal</a>
  </div>
</nav>

<div class="container mt-5">
    <div class="card shadow-lg border-0 p-4">
        <h3 class="text-center text-primary fw-bold mb-4">Add New Job</h3>

        <form action="addJob" method="post">
            <div class="mb-3">
                <label class="form-label fw-semibold">Job Profile</label>
                <input type="text" name="profile" class="form-control" placeholder="e.g., Java Developer" required>
            </div>

            <div class="mb-3">
                <label class="form-label fw-semibold">Job Description</label>
                <textarea name="desc" class="form-control" rows="4" placeholder="Short job summary..." required>Lorem ipsum dolor, sit amet consectetur adipisicing elit. Unde, repellat?</textarea>
            </div>

            <div class="mb-3">
                <label class="form-label fw-semibold">Tech Stack (comma separated)</label>
                <input type="text" name="techs" class="form-control" placeholder="Java, Spring, MySQL" required>
            </div>

            <div class="mb-3">
                <label class="form-label fw-semibold">Required Experience (Years)</label>
                <input type="number" name="exp" class="form-control" min="0" required>
            </div>

            <button type="submit" class="btn btn-success w-100">Add Job</button>
        </form>
        <div class="text-center mt-3">
            <a href="home" class="text-decoration-none">← Back to Home</a>
        </div>
    </div>
</div>

<%
    // redirect after successful add
    if (request.getMethod().equalsIgnoreCase("POST")) {
%>
    <div class="container text-center mt-5">
        <div class="alert alert-success">
            ✅ Job added successfully! Redirecting to home...
        </div>
    </div>
    <script>
        setTimeout(() => { window.location.href = "home"; }, 0);
    </script>
<%
    }
%>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
