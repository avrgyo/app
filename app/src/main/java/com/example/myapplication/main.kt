package com.example.myapplication

fun convertirAFahrenheit(celsius: Double): Double {
    return (celsius * 9 / 5) + 32
}

fun main() {
    val usuario = User(
        nombreCompleto = "Claudia Tona",
        edad = 31,
        fechaNacimiento = "22/02/1994",
        direccion = "Tijuana, BC",
        nombreUsuario = "@claudiatona",
        cuentaVerificada = true
    )

    // Mostrar información inicial
    usuario.mostrarPerfil()
    usuario.mostrarGrupoEdad()

    // Agregar amigos
    println("\n➡️ Agregando amigos:")
    usuario.agregarAmigo("Ana")
    usuario.agregarAmigo("Luis")
    usuario.agregarAmigo("Pedro")
    usuario.mostrarAmigos()

    // Intentar agregar amigos duplicados
    println("\n➡️ Intentando agregar amigos duplicados:")
    usuario.agregarAmigo("María")
    usuario.agregarAmigo("Ana") // Prueba de duplicado

    // Eliminar amigos
    println("\n➡️ Eliminando amigos:")
    usuario.eliminarAmigo("Luis")
    usuario.eliminarAmigo("Carlos") // No existe
    usuario.mostrarAmigos()

    // Editar perfil
    println("\n➡️ Editando perfil:")
    usuario.editarPerfil("Claudia G. Tona", 32)

    // Conversión de temperatura
    println("\n🌡️ Ingresa la temperatura en Celsius:")
    val entrada = readLine()
    val celsius = entrada?.toDoubleOrNull()

    if (celsius != null) {
        val fahrenheit = convertirAFahrenheit(celsius)
        println("🔥 $celsius °C equivale a $fahrenheit °F")
    } else {
        println("⚠️ Entrada inválida.")
    }
}
