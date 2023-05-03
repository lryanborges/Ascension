/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufersa.edu.br.ascension.model.service;

import ufersa.edu.br.ascension.model.entidades.Usuario;

public class UsuarioService {
	public static void exibirPainelDeUsuario(Usuario usuario) {
        System.out.println("\n===================\n");
        System.out.println("Informações do usuário:");
        System.out.println("ID: " + usuario.getId_usuario());
        System.out.println("Login: " + usuario.getLogin());
        System.out.println("Vencidas: " + usuario.getVencidas());
        System.out.println("Herói favorito: " + usuario.getHeroifavorito());
        System.out.println("\n===================\n");
    }
	
	public static void exibirMenuPrincipal() {
		System.out.println("Deseja iniciar uma nova partida (?) s(sim) n");
	}
}