<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Lista de Canciones</title>
</head>
<body>
    <h2>Lista de Canciones</h2>
    <ul>
        <c:forEach items="${listaCanciones}" var="cancion">
            <li>${cancion.titulo} - ${cancion.artista}</li>
        </c:forEach>
    </ul>

    <a href="/canciones/formulario/agregar/0">
        <button>Agregar Cancion</button>
    </a>
</body>
</html>

