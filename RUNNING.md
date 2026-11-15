

<!-- local-development:start -->
# Desarrollo local

Puedes abrir este repositorio en VS Code, Antigravity o Sublime Text. El compilador y los servicios necesarios dependen del componente indicado abajo.

## Java / NetBeans

En NetBeans 25, abre la carpeta que contiene `build.xml` como proyecto Ant. Selecciona un JDK igual o posterior al nivel de fuente del proyecto; las compilaciones de esta revisión usan JDK 24.0.2. El asistente busca NetBeans y el JDK y mantiene la configuración de usuario en `.local-build/`.

```powershell
.uild-local.ps1
.\build-local.ps1 -Project 'Guia/build.xml' -Target run
```

Si hay varios proyectos, elige el deseado con `-Project`. Puedes indicar `-JavaHome` y `-NetBeansHome`. `-Target test` ejecuta las pruebas que declare el proyecto; un objetivo de pruebas vacío no acredita cobertura.

## Python

Crea un entorno por aplicación desde PyCharm o la CLI. Python 3.12 es el punto inicial de compatibilidad; no se presume que todo el código o sus paquetes antiguos ya lo soporten.

```powershell
py -3.12 -m venv .venv
```

No se detectó un archivo requirements. Hay que identificar los imports y declarar las dependencias antes de instalarlas.

## Maven

Abre el `pom.xml` correspondiente en NetBeans. Usa `mvn test` en su carpeta después de revisar plugins y perfiles. Las compilaciones Java/Ant de la tabla no cubren los componentes Maven.

## Componentes y validación

Inventario y compilaciones locales del 2026-11-15. Una compilación correcta no acredita todavía interacción, compatibilidad de base de datos, instalador ni despliegue.

| Componente | Tipo / destino | Validación |
| --- | --- | --- |
| [Calculadora/pom.xml](<Calculadora/pom.xml>) | maven | Compila; comprobado el 2026-11-15; ver alcance actualizado abajo |
| [Guia/build.xml](<Guia/build.xml>) | netbeans-ant / 20 | Compila; prueba funcional pendiente |
| [LabUX/pom.xml](<LabUX/pom.xml>) | maven | Compila; comprobado el 2026-11-15; ver alcance actualizado abajo |

## Archivos ignorados

`.gitignore` excluye credenciales locales, estado del editor y salidas de las herramientas detectadas. No deja de versionar archivos que ya estaban en Git. Los manifiestos, archivos de bloqueo, recursos fuente y scripts de esquema forman parte del código.
<!-- local-development:end -->

<!-- build-repairs-20261115:start -->
## Reparación y comprobación — 2026-11-15

- Se documentaron los comandos de compilación y comprobación con Maven/JDK 24 y se conservaron los cambios previos de README y exclusiones.

Comprobado:

- Maven package terminó correctamente para `Calculadora/pom.xml`, `LabUX/pom.xml`.

Comandos:

```powershell
mvn -f "Calculadora/pom.xml" package
mvn -f "LabUX/pom.xml" package
```

Alcance pendiente:

- Compilar y ejecutar la suite disponible no demuestra todos los flujos gráficos, de datos o de instalación.

<!-- build-repairs-20261115:end -->
