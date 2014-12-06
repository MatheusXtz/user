
package controllers;

import java.util.List;

import models.Usuario;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class UserCrud extends Controller {

	private static final Form<Usuario> userForm = Form.form(Usuario.class);

	public static Result listarUser() {
		List<Usuario> users = Usuario.find.findList();
		return ok(views.html.curso.render(users));
	}
	public static Result gravar() {
		Form<Usuario> form = userForm.bindFromRequest();

		if (form.hasErrors()) {
			flash("erro", "Foram identificados erros no cadastro!");
			return redirect(routes.UserCrud.listarUser());
		}
		Usuario user = form.get();
		user.save();

		flash("sucesso", "Dados Gravados com sucesso");
		return redirect(routes.UserCrud.listarUser());
	}
	
		public static Result detalhar(Long id) {
			Form<Usuario> userForm = Form.form(Usuario.class).fill(Usuario.find.byId(id));
			return ok(views.html.alterarCurso.render(id, userForm));
		}

		public static Result alterar(Long id) {
			Form.form(Usuario.class).fill(Usuario.find.byId(id));

			Form<Usuario> alterarForm = Form.form(Usuario.class).bindFromRequest();
			if (alterarForm.hasErrors()) {
				return badRequest(views.html.alterarCurso.render(id, alterarForm));
			}
			alterarForm.get().update(id);
			flash("sucesso", "Curso " + alterarForm.get().getNome()
					+ " alterado com sucesso");

			return redirect(routes.UserCrud.listarUser());
		}

		public static Result remover(Long id) {
			Usuario.find.ref(id).delete();
			flash("sucesso", "Curso removido com sucesso");
			return listarUser();
		}
	
}
