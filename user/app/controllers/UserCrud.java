
package controllers;

import java.util.List;

import models.User;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class UserCrud extends Controller {

	private static final Form<User> userForm = Form.form(User.class);

	public static Result listarUser() {
		List<User> users = User.find.findList();
		return ok(views.html.curso.render(users));
	}
	public static Result gravar() {
		Form<User> form = userForm.bindFromRequest();

		if (form.hasErrors()) {
			flash("erro", "Foram identificados erros no cadastro!");
			return redirect(routes.UserCrud.listarUser());
		}
		User user = form.get();
		user.save();

		flash("sucesso", "Dados Gravados com sucesso");
		return redirect(routes.UserCrud.listarUser());
	}
	
		public static Result detalhar(Long id) {
			Form<User> userForm = Form.form(User.class).fill(User.find.byId(id));
			return ok(views.html.alterarCurso.render(id, userForm));
		}

		public static Result alterar(Long id) {
			Form.form(User.class).fill(User.find.byId(id));

			Form<User> alterarForm = Form.form(User.class).bindFromRequest();
			if (alterarForm.hasErrors()) {
				return badRequest(views.html.alterarCurso.render(id, alterarForm));
			}
			alterarForm.get().update(id);
			flash("sucesso", "Curso " + alterarForm.get().getNome()
					+ " alterado com sucesso");

			return redirect(routes.UserCrud.listarUser());
		}

		public static Result remover(Long id) {
			User.find.ref(id).delete();
			flash("sucesso", "Curso removido com sucesso");
			return listarUser();
		}
	
}
