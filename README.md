IC-6821 Diseño de Software  
Prof. Diego Munguia Molina  
IC-AL

---

# Proyecto 3 - Sistema de micro financiamiento

## Objetivos de aprendizaje

* Aplicar conceptos de arquitectura de software a la resolución de un problema clásico de ingeniería de software (III)

## Descripción

Queremos desarrollar una arquitectura de software para soportar una plataforma de micro financiamiento en el contexto costarricense.

### Breve contexto: ¿Qué es micro financiamiento?

* El micro financiamiento es una solución técnica que permite que una comunidad pueda financiar, sin fines de lucro, a pequeños emprendedores en situación de pobreza, quienes de otra forma no tendrían acceso al crédito a través de la banca formal, pues no cumplen con requisitos como ingresos mínimos, garantías o fiadores.

* Los micro créditos no tienen fines de lucro para los prestamistas e intermediarios, sin embargo cobran una tasa de interés mínima suficiente para cubrir los costos de operación de la plataforma, la depreciación del dinero prestado por inflación y potenciales pérdidas por impago.

* Uno de los primeros proponentes del micro financiamiento es Muhammad Yunus quien desarrolló el banco comunitario Grameen en Bangladesh durante la década de los 1970s con el fin de empoderar a las comunidades rurales y marginadas sin requerir garantías formales.

* El micro financiamiento más que una técnica, es también una estrategia para la redistribución del acceso al crédito y el empoderamiento económico de pequeños emprendimientos.

* Es una forma de desafiar los fundamentos del modelo económico hegemónico, permitiendo que las personas beneficiarias no dependan de los actores globales, ni de la inversión extranjera.

* Fomenta la autosuficiencia y el fortalecimiento de las economías locales.

* Promueve el desarrollo sostenible, fomentando negocios de pequeño capital, generando ingresos básicos para familias, y aumentando el poder adquisitivo de comunidades marginadas. Esto repercute también en el desarrollo social, mejorando el acceso a servicios básicos como salud y educación.

### Actores involucrados

* Solicitante: la persona o entidad que solicita el crédito con base en una propuesta y que adquiere el compromiso de realizar los pagos en retorno.

* Prestamista: la persona o entidad que ofrece fondos para ser utilizados en micro créditos.

* Plataforma de Micro financiamiento (PMF): sistema que integra los diferentes actores para completar los flujos de información y capital para el financiamiento de las solicitantes.

* Banca formal (BANCA): entidades bancarias, agencias de crédito y pasarelas de pago a través de las cuales se realizará el flujo de capital desde el sistema tradicional hacia la banca comunitaria.

* Centros comunitarios de financiamiento (CCF): organizaciones comunitarias que se establecen en cada una de las comunidades donde opera el sistema de micro financiamiento, tienen como objetivo fungir como el contacto directo con las personas solicitantes para apoyarles durante el proceso, así como determinar los criterios comunitarios de evaluación de riesgo para cada solicitante. Los CCF están compuestos por personas de la comunidad y por personas de la PMF.

### Flujo de información y capital

* La persona solicitante realiza una propuesta de financiamiento a la PMF, indicando el monto requerido, la finalidad que persigue, y las condiciones esperadas (plazo o cuotas). Puede presentar la propuesta en línea o en persona a través del CCF.

* La PMF hace una evaluación del riesgo de la propuesta, con base en la aplicación de una serie de criterios cuantitativos y cualitativos a la información provista por la propuesta y por el CCF con el fin de evaluar la viabilidad de la propuesta de financiamiento.

* Las prestamistas tienen acceso a las propuestas de financiamiento disponibles y deciden cuáles financiar, ya sea total o parcialmente. La PMF recibe el monto ofertado a través de una pasarela de pago BANCA.

* La PMF lleva el registro de las ofertas que se han hecho para cada propuesta y los montos pendientes de financiar.

* Cuando se completan las ofertas para financiar la propuesta, la PMF gestiona el desembolso de los fondos al solicitante, si la solicitante tiene acceso a una cuenta bancaria se hace una transferencia a través de BANCA, en caso contrario se transfieren los fondos al CCF correspondiente a través de BANCA y este hace el desembolso en efectivo a la persona solicitante.

* La solicitante inicia el proceso de pago de acuerdo con las condiciones de la propuesta. De igual forma, los pagos se pueden hacer a través de SINPE Móvil, transferencia o depósito bancario, o en efectivo en el CCF. El CCF gestiona la emisión de comprobantes físicos y digitales a través de correo electrónico o SMS.

* EL CCF transfiere el monto correspondiente al pago al saldo principal a la PMF para que esta lo redistribuya entre las prestamistas. La persona prestamista puede decidir cobrar el dinero o reinvertirlo en otras propuestas.

* Un porcentaje de los intereses cobrados se trasladan a la PMF para cubrir los costos de operación del sistema y el otro porcentaje se asigna al CCF para construir un capital social que puede ser utilizado para cubrir pérdidas y para financiar nuevas propuestas o hacer inversión comunitaria.

* Al finalizar el ciclo de pagos, ya sea por completitud o por incumplimiento, se cierra la operación de crédito y se emiten reportes históricos del proceso a las solicitantes y prestamistas.

###  Especificación

El proyecto consiste en implementar e integrar los tres componentes tecnológicos del sistema de micro financiamiento: BANCA, PMF y CCF.

Se deben diseñar e implementar los modelos de datos y APIs REST para implementar las responsabilidades de cada componente. No se desarrollará ningún tipo de interfaz de usuario.

#### Responsabilidades

BANCA

* Funcionar como una pasarela de pago: Recibir depósitos a una cuenta a través de SINPE Móvil, tarjeta de crédito o depósito bancario manual, y realizar una llamada *callback* a un endpoint dado (ya sea de la PMF o del CCF) para procesar el pago. (Por simplicidad no considera el débito a la cuenta de origen).
* Realizar transferencias entre cuentas.
* Registrar retiros en efectivo.
* Llevar registro de ingresos y egresos de las cuentas bancarias y generar el reporte correspondiente para un rango de fechas.

PMF Mercado de propuestas

* Recibe propuestas de financiamiento.
* Recibir calificación de riesgo de la propuesta por parte del CCF representada como un porcentaje de probabilidad de cumplimiento. Los miembros del CCF hacen una evaluación cualitativa de la propuesta a través de entrevistas, deliberan y otorgan la evaluación de riesgo.
* Publicar las propuestas recibidas a las prestamistas.
* Recibir ofertas de financiamiento a propuestas, y llevar registro de los montos pendientes de financiar.
* Realizar el desembolso de fondos.
* Registrar pagos de intereses y pagos a saldos principales a las prestamistas. El monto del principal se divide proporcionalmente entre las prestamistas de acuerdo con las ofertas recibidas.
* Cerrar operaciones de crédito y generar reporte histórico correspondiente.

PMF Evaluación de riesgo

* Evaluar el riesgo de cada propuesta y calificarlo como una probabilidad de cumplimiento. El riesgo se evalúa con base en la calificación hecha por el CCF e incluida en la propuesta, y en una evaluación con base en el historial previo de la persona solicitante en la PMF. Esta evaluación sigue las siguientes reglas: si es la primera propuesta de la solicitante se le da el beneficio de la duda y se le otorga un 100% de probabilidad de cumplimiento, en caso contrario se calcula una proporción (# pagos realizados / # pagos de la operación) para todas sus operaciones anteriores. Ambos porcentajes de riesgo (de CCF y de PMF) se ponderan dando 65% de peso al del CCF  y 35% al del PMF. Estos porcentajes deben ser fácilmente configurables.  

CCF

* Registrar desembolso de fondos en efectivo, generar el comprobante correspondiente y enviarlo a través de SMS o Email.
* Registrar pagos de solicitante y generar los comprobantes correspondientes notificando a través de SMS o Email.
* Llevar registro del monto recibido por intereses y trasladar el resto de intereses y principal a la PMF. La tasa de interés es anual y simple, y se almacena como parte de la propuesta de financimiento, así como los porcentajes de este interés que corresponden al CCF y a la PMF.

#### Requerimientos no funcionales

* Seguridad
  * Confidencialidad: los usuarios solo pueden acceder a los datos de los que son dueños.
  * Autenticidad: los usuarios deben ser autenticados para acceder a los datos.
  * Trazabilidad: los datos deben ser auditados para su seguimiento.

* Compatibilidad
  * Interoperabilidad: los componentes deben ser interoperables con otros sistemas.
  * Reemplazabilidad: la base de datos debe ser reemplazable por una base de datos persistente en el futuro.

* Matenibilidad
  * *Testability* (capacidad de pruebas): la funcionalidad de los componentes deben ser verificados a través de pruebas automatizadas.
  * Modularidad: los módulos deben presentar alta cohesión y bajo acoplamiento.

* Robustez (Confiabilidad)
  * Tolerancia a fallos: los componentes deben mantenerse en funcionamiento a pesar de fallos en la integración con los otros componentes.

#### Decisiones técnicas

* Cada componente será desarrollado en Java con SpringBoot, utilizando una base de datos HSQLDB en memoria versionada con Flyway.
* Se espera el cumplimiento de los principios de programación orientada a objetos y de diseño.
* Cada grupo decidirá el patrón arquitectónico a utilizar para la integración entre los componentes.
* El diseño interno de cada componente seguirá un patrón arquitectónico de diseño en capas.
* Cada componente se implementará en los subproyectos disponibles en este repositorio nombrados `PMF-mercado/`, `PMF-riesgo/`, `CCF/` y `BANCA/`.
* Cada componente debe incluir pruebas de integración para los repositorios (capa de acceso a datos) y pruebas unitarias para los servicios y controladores.
* Cada componente incluirá un script de carga de datos de demostración (*seed data*) a través de una versión de Flyway.
* Los componentes externos de notificación como SMS y correo electrónico no deben ser implementados funcionalmente, sino que pueden ser simulados (*mocked*) a través de una abstracción adecuada.
* Los componentes externos de pago como SINPE Móvil y Pasarela de pago (tarjeta de crédito) no deben ser implementados funcionalmente, sino que se debe asumir que un endpoint de nuestro API es invocado a través de esos componentes, este endpoint recibe los datos relevantes generados por el componente externo según la operación que se esté realizando.
* Todas las API REST deben ser documentadas con Spring REST Docs.

#### Consideraciones logísticas

* Cada grupo se dividirá en tres subgrupos A, B y C.
* El subgrupo A se hará cargo del componente `PMF-mercado/`
* El subgrupo B se hará cargo de los componentes `PMF-riesgo/` y `CCF/`
* El subgrupo C se hará cargo del componente `BANCA/`
* Los subgrupos deben coordinar entre sí las interfaces REST que utilizarán para la integración con los otros componentes. El diseño debe considerar la alta posibilidad de que estas interfaces deban cambiar sobre la marcha.
* Ningún subgrupo debe hacer commits en un componente que no le corresponda.
* Cada subgrupo será evaluado individualmente.
