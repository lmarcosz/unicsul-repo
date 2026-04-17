package org.example

import kotlin.random.Random

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val op = arrayOf("Pedra","Papel","Tesoura")

    do {
        val p2 : Int= Random.nextInt(1,3)
        print("\nEscolha uma opcao:\n[1]Pedra\n[2]Papel\n[3]Tesoura\n[0]Sair\n=> ")
        val p1 : Int = Integer.parseInt(readln())

        if(p1==1 || p1==2 || p1==3) {
            println("O adversario jogou " + op[(p2)-1] +" (" + p2 + ")")

            when (p1) {
                1 ->
                    if (p2 == 2) {
                        println("Voce perdeu!")
                    } else if (p2 == 3) {
                        println("Voce ganhou!")
                    }

                2 ->
                    if (p2 == 1) {
                        println("Voce ganhou!")
                    } else if (p2 == 3) {
                        println("Voce perdeu!")
                    }

                3 ->
                    if (p2 == 1) {
                        println("Voce perdeu!")
                    } else if (p2 == 2) {
                        println("Voce ganhou!")
                    }
            }

            if(p1==p2){
                println("Voces empataram!")
            }

        } else if(p1==0){
            println("Saindo...")
        } else{
            println("Valor invalido! Digite novamente")
        }
    } while(p1 != 0);

}
