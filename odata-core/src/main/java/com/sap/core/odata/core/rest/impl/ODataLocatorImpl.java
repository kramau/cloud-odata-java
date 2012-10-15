package com.sap.core.odata.core.rest.impl;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sap.core.odata.core.processor.Processor;
import com.sap.core.odata.core.producer.Entity;
import com.sap.core.odata.core.producer.Metadata;
import com.sap.core.odata.core.producer.ODataProducer;
import com.sap.core.odata.core.rest.ODataLocator;
import com.sap.core.odata.core.uri.UriParser;

public final class ODataLocatorImpl implements ODataLocator {

  private static final Logger log = LoggerFactory.getLogger(ODataLocatorImpl.class);

  private ODataContextImpl context;

  private ODataProducer producer;
  
  private Processor processor;
  
  private UriParser uriParser;

  @Override
  public ODataProducer getProducer() {
    return this.producer;
  }

  @Override
  public Response handleGet() {
    ODataLocatorImpl.log.debug("+++ ODataSubResource:handleGet()");
    this.context.log();

    if (this.producer.isEntity()) {
      this.producer.getEntity().read();
    }
    
    return Response.ok().entity("GET: status 200 ok").build();
  }

  @Override
  @POST
  @Produces(MediaType.TEXT_PLAIN)
  public Response handlePost(
      @HeaderParam("X-HTTP-Method") String xmethod
      ) {

    ODataLocatorImpl.log.debug("+++ ODataSubResource:handlePost()");
    Response response;

    /* tunneling */
    if (xmethod == null) {
      this.context.log();
      response = Response.ok().entity("POST: status 200 ok").build();
    } else if ("MERGE".equals(xmethod)) {
      response = this.handleMerge();
    } else if ("PATCH".equals(xmethod)) {
      response = this.handlePatch();
    } else {
      response = Response.status(405).build(); // method not allowed!
    }

    return response;
  }

  @Override
  public Response handlePut() {
    ODataLocatorImpl.log.debug("+++ ODataSubResource:handlePut()");
    this.context.log();

    return Response.ok().entity("PUT: status 200 ok").build();
  }

  @Override
  public Response handlePatch() {
    ODataLocatorImpl.log.debug("+++ ODataSubResource:handlePatch()");
    this.context.log();

    return Response.ok().entity("PATCH: status 200 ok").build();
  }

  @Override
  public Response handleMerge() {
    ODataLocatorImpl.log.debug("+++ ODataSubResource:handleMerge()");
    this.context.log();

    return Response.ok().entity("MERGE: status 200 ok").build();
  }

  @Override
  public Response handleDelete() {
    ODataLocatorImpl.log.debug("+++ ODataSubResource:handleDelete()");
    this.context.log();

    return Response.ok().entity("DELETE: status 200 ok").build();
  }

  public void setContext(ODataContextImpl context) {
    this.context = context;
  }

  public void setProducer(ODataProducer producer) {
    this.producer = producer;
  }

  @Override
  public void beforRequest() {
    
    Metadata metadata = this.producer.getMetadata();
    
    this.uriParser = new UriParser(metadata.getEdm());
    this.processor = new Processor();
  }

}