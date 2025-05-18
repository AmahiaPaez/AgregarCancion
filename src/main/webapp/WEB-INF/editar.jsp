<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Editar Cancion</title>
</head>
<body>
    <h2>Editar Cancion</h2>

    <form:form method="post" modelAttribute="cancion" action="/canciones/procesa/editar/${cancion.id}">
        <p>Titulo: <form:input path="titulo" /> 
        <p>Artista: <form:input path="artista" /> 
        <p>Album: <form:input path="album" /> 
        <p>Genero: <form:input path="genero" /> 
        <p>Idioma: <form:input path="idioma" /> 
        <input type="submit" value="Actualizar Cancion" />
    </form:form>

    <a href="/canciones">Volver a lista de canciones</a>
</body>
</html>
