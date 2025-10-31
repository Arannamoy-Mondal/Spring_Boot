<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Job Portal - Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        html, body {
            height: 100%;
        }
        body {
            display: flex;
            flex-direction: column;
            background-color: #f8f9fa;
        }
        main {
            flex: 1; /* Push footer to bottom when content is short */
        }
        footer {
            background-color: #212529;
            color: #fff;
            text-align: center;
            padding: 12px 0;
            margin-top: auto;
        }
    </style>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand fw-bold" href="#">Job Portal</a>
    <div class="d-flex">
      <a href="addJob" class="btn btn-success">+ Add Job</a>
    </div>
  </div>
</nav>

<main class="container mt-4">
    <h3 class="text-center mb-4 fw-bold text-primary">Available Job Posts</h3>

    <div class="row">
        <c:forEach var="job" items="${jp}">
            <div class="col-md-4 mb-4">
                <div class="card shadow-sm border-0 h-100">
                    <div class="card-body">
                        <h5 class="card-title text-success">${job.postProfile}</h5>
                        <p class="card-text text-muted small">${job.postDescription}</p>
                        <p><strong>Tech Stack:</strong> ${job.postTechStack}</p>
                        <span class="badge bg-info text-dark">${job.reqExperience} Years Experience</span>
                    </div>
                </div>
            </div>
        </c:forEach>

        <c:if test="${empty jp}">
            <div class="text-center text-muted mt-5">
                <p>No jobs available. Add a new one!</p>
            </div>
        </c:if>
    </div>
</main>

<footer>
    © 2025 Job Portal by Aranna
</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
