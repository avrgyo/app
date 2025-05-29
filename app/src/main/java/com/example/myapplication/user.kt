package com.example.myapplication

class User(
    var nombreCompleto: String,
    var edad: Int,
    val fechaNacimiento: String,
    var direccion: String,
    var nombreUsuario: String,
    val cuentaVerificada: Boolean
) {
    private val amigos = mutableListOf<String>()

    fun mostrarPerfil() {
        println("\n📄 Información del perfil:")
        println("Nombre: $nombreCompleto")
        println("Edad: $edad")
        println("Fecha de nacimiento: $fechaNacimiento")
        println("Dirección: $direccion")
        println("Nombre de usuario: $nombreUsuario")
        println("Cuenta verificada: ${if (cuentaVerificada) "Sí" else "No"}")
        println("✅ ¡Bienvenida de nuevo, $nombreCompleto!")
    }

    fun mostrarGrupoEdad() {
        val grupo = when {
            edad < 13 -> "Niño"
            edad in 13..17 -> "Adolescente"
            edad in 18..59 -> "Adulto"
            else -> "Adulto mayor"
        }
        println("👤 Grupo de edad: $grupo")
    }

    fun mostrarAmigos() {
        println("\n👥 Lista de amigos (${amigos.size}):")
        if (amigos.isEmpty()) {
            println("No tienes amigos registrados.")
        } else {
            amigos.forEach { println("- $it") }
        }
    }

    fun agregarAmigo(nombre: String) {
        if (amigos.contains(nombre)) {
            println("⚠️ $nombre ya está en tu lista de amigos.")
        } else {
            amigos.add(nombre)
            println("✅ $nombre ha sido agregado a tu lista de amigos.")
        }
    }

    fun eliminarAmigo(nombre: String) {
        if (amigos.remove(nombre)) {
            println("🗑️ $nombre ha sido eliminado de tu lista de amigos.")
        } else {
            println("❌ $nombre no está en tu lista de amigos.")
        }
    }

    fun editarPerfil(nuevoNombre: String, nuevaEdad: Int) {
        nombreCompleto = nuevoNombre
        edad = nuevaEdad
        println("✏️ Perfil actualizado: $nombreCompleto, $edad años.")
    }
}
