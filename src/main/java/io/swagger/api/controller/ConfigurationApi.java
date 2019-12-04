/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.14).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.model.ModelConfiguration;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-11-16T21:07:28.234Z[GMT]")
@Api(value = "configuration", description = "the configuration API")
public interface ConfigurationApi {

    @ApiOperation(value = "Obtener configuración", nickname = "getConf", notes = "Cargar la configuración del sistema", response = ModelConfiguration.class, tags={ "Configuracion", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Operación realizada con éxito", response = ModelConfiguration.class) })
    @RequestMapping(value = "/configuration",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<ModelConfiguration> getConf();


    @ApiOperation(value = "Cambiar configuración", nickname = "updateConf", notes = "Permite cambiar la configuración del sistema", tags={ "Configuracion", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Operación realizada con éxito"),
        @ApiResponse(code = 405, message = "Entrada inválida") })
    @RequestMapping(value = "/configuration",
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> updateConf(@ApiParam(value = "Nueva configuración" ,required=true )  @Valid @RequestBody ModelConfiguration body);

}
