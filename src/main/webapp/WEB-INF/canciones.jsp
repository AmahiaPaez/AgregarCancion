<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Lista de Canciones</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css" />
</head>
<body>

	<div class="containerPadre">
	    <div class="container">
	        <h2>Lista de Canciones</h2>
	        <ul class="lista-canciones">
	            <c:forEach items="${listaCanciones}" var="cancion">
	                <li class="fila-cancion">
	                    <span class="info-cancion">${cancion.titulo} - ${cancion.artista}</span>
	                    <form action="/canciones/procesa/eliminar/${cancion.id}" method="post">
	                        <input type="hidden" name="_method" value="delete"/>
	                        <button type="submit" class="btn-eliminar">Eliminar</button>
	                    </form>
	                </li>
	            </c:forEach>
	        </ul>
	    </div>
	</div>

	<div class="btn">
		<a href="/canciones/formulario/agregar">
			<button>Agregar una cancion</button>
		</a>
	</div>

				
</body>
</html>
