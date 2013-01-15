package com.sap.core.odata.core.ep;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import com.sap.core.odata.api.edm.Edm;
import com.sap.core.odata.api.edm.EdmEntitySet;
import com.sap.core.odata.api.edm.EdmFunctionImport;
import com.sap.core.odata.api.edm.EdmProperty;
import com.sap.core.odata.api.ep.EntityProviderException;
import com.sap.core.odata.api.ep.EntityProviderProperties;
import com.sap.core.odata.api.ep.EntityProvider.ProviderInterface;
import com.sap.core.odata.api.exception.ODataNotAcceptableException;
import com.sap.core.odata.api.exception.ODataNotImplementedException;
import com.sap.core.odata.api.processor.ODataResponse;
import com.sap.core.odata.core.commons.ContentType;

public class ProviderFacadeImpl implements ProviderInterface {

  private static BasicEntityProvider create() throws EntityProviderException {
    return new BasicEntityProvider();
  }

  private static ContentTypeBasedEntityProvider create(String contentType) throws EntityProviderException {
    return create(ContentType.create(contentType));
  }

  private static ContentTypeBasedEntityProvider create(ContentType contentType) throws EntityProviderException {
    try {
      ContentTypeBasedEntityProvider provider;

      switch (contentType.getODataFormat()) {
      case ATOM:
      case XML:
        provider = new AtomEntityProvider();
        break;
      case JSON:
        throw new ODataNotImplementedException();
      default:
        throw new ODataNotAcceptableException(ODataNotAcceptableException.NOT_SUPPORTED_CONTENT_TYPE.addContent(contentType));
      }

      return provider;
    } catch (ODataNotImplementedException e) {
      throw new EntityProviderException(EntityProviderException.COMMON, e);
    } catch (ODataNotAcceptableException e) {
      throw new EntityProviderException(EntityProviderException.COMMON, e);
    }
  }

  @Override
  public Object readPropertyValue(EdmProperty edmProperty, InputStream content) throws EntityProviderException {
    return create().readPropertyValue(edmProperty, content);
  }

  @Override
  public String readText(InputStream content) throws EntityProviderException {
    return create().readText(content);
  }

  @Override
  public byte[] readBinary(String mimeType, InputStream content) throws EntityProviderException {
    return create().readBinary(mimeType, content);
  }

  @Override
  public ODataResponse writeServiceDocument(Edm edm, String serviceRoot) throws EntityProviderException {
    return create().writeServiceDocument(edm, serviceRoot);
  }

  @Override
  public ODataResponse writePropertyValue(EdmProperty edmProperty, Object value) throws EntityProviderException {
    return create().writePropertyValue(edmProperty, value);
  }

  @Override
  public ODataResponse writeText(String value) throws EntityProviderException {
    return create().writeText(value);
  }

  @Override
  public ODataResponse writeBinary(String mimeType, byte[] data) throws EntityProviderException {
    return create().writeBinary(mimeType, data);
  }

  @Override
  public Map<String, Object> readEntry(String contentType, EdmEntitySet entitySet, InputStream content) throws EntityProviderException {
    return create(contentType).readEntry(entitySet, content);
  }

  @Override
  public Map<String, Object> readLink(String contentType, EdmEntitySet entitySet, InputStream content) throws EntityProviderException {
    return create(contentType).readLink(entitySet, content);
  }

  @Override
  public Map<String, Object> readProperty(String contentType, EdmProperty edmProperty, InputStream content) throws EntityProviderException {
    return create(contentType).readProperty(edmProperty, content);
  }

  @Override
  public List<Map<String, Object>> readLinks(String contentType, EdmEntitySet entitySet, InputStream content) throws EntityProviderException {
    return create(contentType).readLinks(entitySet, content);
  }

  @Override
  public ODataResponse writeFeed(String contentType, EdmEntitySet entitySet, List<Map<String, Object>> data, EntityProviderProperties properties) throws EntityProviderException {
    return create(contentType).writeFeed(entitySet, data, properties);
  }

  @Override
  public ODataResponse writeEntry(String contentType, EdmEntitySet entitySet, Map<String, Object> data, EntityProviderProperties properties) throws EntityProviderException {
    return create(contentType).writeEntry(entitySet, data, properties);
  }

  @Override
  public ODataResponse writeProperty(String contentType, EdmProperty edmProperty, Object value) throws EntityProviderException {
    return create(contentType).writeProperty(edmProperty, value);
  }

  @Override
  public ODataResponse writeLink(String contentType, EdmEntitySet entitySet, Map<String, Object> data, EntityProviderProperties properties) throws EntityProviderException {
    return create(contentType).writeLink(entitySet, data, properties);
  }

  @Override
  public ODataResponse writeLinks(String contentType, EdmEntitySet entitySet, List<Map<String, Object>> data, EntityProviderProperties properties) throws EntityProviderException {
    return create(contentType).writeLinks(entitySet, data, properties);
  }

  @Override
  public ODataResponse writeFunctionImport(String contentType, EdmFunctionImport functionImport, Object data, EntityProviderProperties properties) throws EntityProviderException {
    return create(contentType).writeFunctionImport(functionImport, data, properties);
  }

}