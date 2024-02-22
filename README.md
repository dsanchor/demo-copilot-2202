# Documentación de la API de Strings

## Concatenar dos strings

Este endpoint concatena dos strings.

**URL**: `/api/strings/concat`

**Método**: `GET`

**Parámetros de consulta**:

- `s1`: Primer string a concatenar.
- `s2`: Segundo string a concatenar.

**Ejemplo de uso con curl**:

```bash
curl -X GET 'http://localhost:8080/api/strings/concat?s1=hello&s2=world'
```

## Obtener un substring

Este endpoint devuelve un substring de un string dado.

**URL**: `/api/strings/substring`

**Método**: `GET`

**Parámetros de consulta**:

- `s`: String del que obtener el substring.
- `beginIndex`: Índice inicial del substring.
- `endIndex`: Índice final del substring.

**Ejemplo de uso con curl**:

```bash
curl -X GET 'http://localhost:8080/api/strings/substring?s=hello&beginIndex=0&endIndex=2'
```

## Verificar si un string contiene un substring

Este endpoint verifica si un string dado contiene un substring dado.

**URL**: `/api/strings/contains`

**Método**: `GET`

**Parámetros de consulta**:

- `s`: String en el que buscar el substring.
- `substring`: Substring a buscar.

**Ejemplo de uso con curl**:

```bash
curl -X GET 'http://localhost:8080/api/strings/contains?s=hello&substring=ell'
```

Estos comandos asumen que tu aplicación se está ejecutando en `localhost` en el puerto `8080`. Si estás ejecutando la aplicación en un host o puerto diferente, necesitarás ajustar las URLs en consecuencia.

## Containerización de la aplicación

### Construir la imagen de Docker

Para construir la imagen de Docker, ejecuta el siguiente comando:

```bash
docker build -t strings-api .
```

### Ejecutar la imagen de Docker

Para ejecutar la imagen de Docker, ejecuta el siguiente comando:

```bash
docker run -p 8080:8080 strings-api
```
