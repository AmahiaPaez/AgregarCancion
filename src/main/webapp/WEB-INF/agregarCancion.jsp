<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Agregar Cancion</title>
</head>
<body>
    <h2>Agregar Cancion</h2>

    <form:form method="post" modelAttribute="cancion" action="/canciones/procesa/agregar">
        <p>Titulo: <form:input path="titulo" /> <form:errors path="titulo" cssClass="error" /></p>
        <p>Artista: <form:input path="artista" /> <form:errors path="artista" cssClass="error" /></p>
        <p>Album: <form:input path="album" /> <form:errors path="album" cssClass="error" /></p>
        <p>Genero: <form:input path="genero" /> <form:errors path="genero" cssClass="error" /></p>
        <p>Idioma: <form:input path="idioma" /> <form:errors path="idioma" cssClass="error" /></p>
        <input type="submit" value="Agregar Canción" />
    </form:form>

    <a href="/canciones">Volver a lista de canciones</a>
</body>
</html>
