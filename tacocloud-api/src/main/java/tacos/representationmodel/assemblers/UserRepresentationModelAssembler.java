package tacos.representationmodel.assemblers;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;

import tacos.controller.UserRestController;
import tacos.domain.User;
import tacos.representationmodel.UserRepresentationModel;

public class UserRepresentationModelAssembler
		extends RepresentationModelAssemblerSupport<User, UserRepresentationModel> {

	public UserRepresentationModelAssembler() {
		super(UserRestController.class, UserRepresentationModel.class);
	}

	@Override
	public UserRepresentationModel toModel(User user) {
		return createModelWithId(user.getId(), user);

	}

	@Override
	protected UserRepresentationModel instantiateModel(User entity) {
		// TODO Auto-generated method stub
		return new UserRepresentationModel(entity);
	}
	

}
