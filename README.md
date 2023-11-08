# latampro
Web de CTF (Capture The Flag) en el campo de Osint, Informática Forense y Ciberseguridad

# Requerimientos del Proyecto CTF

## Requerimientos Funcionales:

1. **Autenticación y Autorización:**
   - Los usuarios deben poder registrarse con un nickname, correo electrónico y contraseña.
   - Debe haber dos roles: administrador y usuario.
   - El administrador debe poder gestionar usuarios (crear, leer, actualizar, eliminar - CRUD).
   - El administrador debe poder asignar y gestionar roles de usuario.

2. **Gestión de Retos:**
   - Los retos deben tener un ID único, descripción, pistas (máximo 3), y puntaje asociado.
   - Los retos deben estar organizados en categorías.
   - Los administradores deben poder crear, leer, actualizar y eliminar retos (CRUD).
   - Las pistas deben poder ser añadidas, modificadas o eliminadas por los administradores.

3. **Gestión de Categorías:**
   - Las categorías deben tener un nombre, ID único y descripción.
   - Las categorías deben contener uno o más retos.
   - Los administradores deben poder crear, leer, actualizar y eliminar categorías (CRUD).

4. **Puntajes y Ranking:**
   - Los usuarios deben ganar puntos al resolver retos correctamente.
   - Debe haber un sistema de puntaje que se actualice cuando se resuelve un reto.
   - Debe haber una página de ranking que muestre a los usuarios ordenados por puntaje, de mayor a menor.

## Requerimientos no Funcionales:

1. **Seguridad:**
   - La contraseña de los usuarios debe estar cifrada y almacenada de forma segura.
   - Las sesiones de usuario deben ser seguras y protegidas contra ataques de sesión.
   - Debe haber medidas de seguridad para prevenir inyecciones SQL y otros ataques comunes.

2. **Interfaz de Usuario (UI):**
   - Debe haber una página de inicio con opciones de login, registro y acceso al ranking.
   - Los usuarios deben tener un área personal donde puedan ver su perfil, retos y puntajes.
   - El administrador debe tener una interfaz de administración para gestionar usuarios, categorías y retos.

3. **Rendimiento:**
   - La aplicación debe ser eficiente y capaz de manejar múltiples solicitudes simultáneamente.
   - Debe haber una respuesta rápida del servidor al interactuar con la base de datos y al cargar páginas.

4. **Escalabilidad:**
   - La aplicación debe ser escalable para manejar un crecimiento futuro en el número de usuarios y retos.

5. **Documentación:**
   - Debe haber documentación clara para los usuarios y administradores sobre cómo usar la plataforma, resolver retos y gestionar contenido.

6. **Integración:**
   - La aplicación debe poder enviar correos electrónicos para confirmaciones de registro y otras notificaciones importantes.
