<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <meta charset="ISO-8859-1">
    <title>AppVenda</title>
</head>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <div class="container-fluid">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link active" href="/">AppVenda</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/vendedor/lista">Vendedores</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/produto/lista">Produtos</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/movel/lista">Moveis </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/livro/lista">Livros </a>
            </li>
        </ul>
    </div>
</nav>

<div class="container container-fluid">

    <span class="badge rounded-pill bg-primary">Vendedor:${qtdVendedores}</span>
    <span class="badge rounded-pill bg-secondary">Produto:${qtdProdutos}</span>
    <span class="badge rounded-pill bg-success">Moveis:${qtdMoveis}</span>
    <span class="badge rounded-pill bg-danger">Livros:${qtdLivros}</span>

    <c:if test="${not empty listagem}">
        <h2>AppVenda</h2>
        <p>Gest�o de vendas de produtos:</p>
        <table class="table">
            <thead class="table-dark">
            <tr>
                <th>${titulo}</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${listagem}">
                <tr>
                    <td>${item}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>
</body>
</html>