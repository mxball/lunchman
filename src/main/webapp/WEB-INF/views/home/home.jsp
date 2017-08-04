<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <title>
            Insira o documento
        </title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="/css/bootstrap.min.css"> 
        <link rel="stylesheet" href="/css/home.css"> 
    </head>
    <body>
        <div class="container">
            <div class="header clearfix">
                <h3 class="text-muted">Restaurante</h3>
            </div>
            <div class="col">
                <form role="form" action="/lunch" method="post" class="form" enctype="multipart/form-data">
                    <fieldset>
                        <legend>Dados do restaurante</legend>
                        <div>
                        		<label>Tipo:</label>
                        		<input type="text" name="tipo"></inputs>
						</div>
						<div>
							<input type="submit" value="enviar"/>
						</div>
                    </fieldset>
                </form>
            </div>
        </div>
        <div class="container">
            <div class="header clearfix">
                <h3 class="text-muted">Eventos</h3>
            </div>
            <div class="col">
                <form role="form" action="/evento" method="post" class="form" enctype="multipart/form-data">
                    <fieldset>
                        <legend>Dados do evneto</legend>    
						<div>
							<input type="submit" value="enviar"/>
						</div>
                    </fieldset>
                </form>
            </div>
        </div>
    </body>
</html>