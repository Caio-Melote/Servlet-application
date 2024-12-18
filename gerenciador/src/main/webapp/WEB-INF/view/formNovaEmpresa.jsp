<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/entrada" var="linkNovaEmpresa"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nova Empresa</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f4f4f4;
    }

    .form-container {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    .form-content {
        max-width: 400px;
        width: 100%;
        padding: 20px;
        background-color: white;
        border-radius: 10px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    h2 {
        text-align: center;
        color: #333;
    }

    .form-group {
        margin-bottom: 15px;
    }

    label {
        display: block;
        margin-bottom: 5px;
        color: #333;
    }

    input[type="text"] {
        width: 100%;
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 5px;
        box-sizing: border-box;
    }

    input[type="submit"] {
        width: 100%;
        padding: 10px;
        background-color: #00ACAC;
        color: white;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        margin-top: 10px;
    }

    input[type="submit"]:hover {
        background-color: #202C3A;
    }
</style>
</head>
<body>
<c:import url="logout-parcial.jsp" />

    <div class="form-container">
        <div class="form-content">
            <h2>Nova Empresa</h2>
            <form action="${linkNovaEmpresa}" method="post">

                <div class="form-group">
                    <label for="nome">Nome:</label>
                    <input type="text" id="nome" name="nome" />
                </div>

                <div class="form-group">
                    <label for="data">Data Abertura:</label>
                    <input type="text" id="data" name="data" />
                </div>

                <input type="hidden" name="acao" value="NovaEmpresa">
                <input type="submit" value="Cadastrar Empresa" />
            </form>
        </div>
    </div>
</body>
</html>
