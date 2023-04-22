// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }
data class Usuario(var nome: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60, val nivel: Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }

    fun getUsuariosInscritos():List<Usuario>{
        return inscritos
    }

    fun duracaoTotal(): Int {
        var horas = 0
        for (conteudo in conteudos) horas += conteudo.duracao
        return horas
    }
}

fun main() {
    val usr1 = Usuario("Jonh")
    val usr2 = Usuario("mary")

    val conteudo1 = ConteudoEducacional("Aprendendo Kotlin",1, Nivel.BASICO)
    val conteudo2 = ConteudoEducacional("Desafio Kotlin",2, Nivel.BASICO)

    val formacaoKotlin = Formacao("Formação Kotlin", listOf(conteudo1, conteudo2))
    formacaoKotlin.matricular(usr1)
    formacaoKotlin.matricular(usr2)

    println("Formação kotlin")
    for (conteudo in formacaoKotlin.conteudos){
        println("${conteudo.nome}  |  ${conteudo.duracao} hrs  | ${conteudo.nivel}")
    }

    println( "Inscritos")
    for (usuario in formacaoKotlin.getUsuariosInscritos()){
        println("Nome: ${usuario.nome}")
    }
}
