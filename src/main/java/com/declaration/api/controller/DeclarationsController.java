package com.declaration.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.declaration.api.components.entity.FilterShortDeclaration;
import com.declaration.api.components.entity.ShortDeclaration;
import com.declaration.api.components.entity.Response;
import com.declaration.api.components.enums.StatusResponse;
import com.declaration.api.service.DeclarationService;

/**
 * Controller for return list of declarations
 * 
 * @author olegnovatskiy
 *
 */
@RestController
@RequestMapping("/component/declarations")
public class DeclarationsController {

	@Autowired
	private DeclarationService declarationService;

	/**
	 * Method finds declarations 
	 * RequestMethod - POST
	 * 
	 * @param filterShortDeclaration - data for filter
	 * @return List<ShortDeclaration> - list declarations with short set of data
	 */
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public Response<ShortDeclaration> search(@RequestBody FilterShortDeclaration filterShortDeclaration) {
		if (filterShortDeclaration.getYearCreateDeclaration() == null || filterShortDeclaration.getLimitBatch() == null
				|| filterShortDeclaration.getPageBatch() == null) {
			
			return new Response<>(StatusResponse.ERROR, "Fields yearCreateDaclaration, limitBatch and pageBatch are required!!!", null);
		} else {
			
			return new Response<>(StatusResponse.SUCCESS, "Search is successfull", declarationService.search(filterShortDeclaration));
		}
	}

}
