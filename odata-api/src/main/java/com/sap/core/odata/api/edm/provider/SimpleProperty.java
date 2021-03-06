/*******************************************************************************
 * Copyright 2013 SAP AG
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package com.sap.core.odata.api.edm.provider;

import java.util.List;

import com.sap.core.odata.api.edm.EdmFacets;
import com.sap.core.odata.api.edm.EdmSimpleTypeKind;

/**
 * Objects of this class represent a simple property
 * @author SAP AG
 */
public class SimpleProperty extends Property {

  private EdmSimpleTypeKind type;

  /**
   * @return {@link EdmSimpleTypeKind} of this property
   */
  public EdmSimpleTypeKind getType() {
    return type;
  }

  /**
   * Sets the {@link EdmSimpleTypeKind} for this {@link Property}
   * @param type
   * @return {@link Property} for method chaining
   */
  public SimpleProperty setType(final EdmSimpleTypeKind type) {
    this.type = type;
    return this;
  }

  /* (non-Javadoc)
   * @see com.sap.core.odata.api.edm.provider.Property#setName(java.lang.String)
   */
  @Override
  public SimpleProperty setName(final String name) {
    super.setName(name);
    return this;
  }

  /* (non-Javadoc)
   * @see com.sap.core.odata.api.edm.provider.Property#setFacets(com.sap.core.odata.api.edm.EdmFacets)
   */
  @Override
  public SimpleProperty setFacets(final EdmFacets facets) {
    super.setFacets(facets);
    return this;
  }

  /* (non-Javadoc)
   * @see com.sap.core.odata.api.edm.provider.Property#setCustomizableFeedMappings(com.sap.core.odata.api.edm.provider.CustomizableFeedMappings)
   */
  @Override
  public SimpleProperty setCustomizableFeedMappings(final CustomizableFeedMappings customizableFeedMappings) {
    super.setCustomizableFeedMappings(customizableFeedMappings);
    return this;
  }

  /* (non-Javadoc)
   * @see com.sap.core.odata.api.edm.provider.Property#setMimeType(java.lang.String)
   */
  @Override
  public SimpleProperty setMimeType(final String mimeType) {
    super.setMimeType(mimeType);
    return this;
  }

  /* (non-Javadoc)
   * @see com.sap.core.odata.api.edm.provider.Property#setMapping(com.sap.core.odata.api.edm.provider.Mapping)
   */
  @Override
  public SimpleProperty setMapping(final Mapping mapping) {
    super.setMapping(mapping);
    return this;
  }

  /* (non-Javadoc)
   * @see com.sap.core.odata.api.edm.provider.Property#setDocumentation(com.sap.core.odata.api.edm.provider.Documentation)
   */
  @Override
  public SimpleProperty setDocumentation(final Documentation documentation) {
    super.setDocumentation(documentation);
    return this;
  }

  /* (non-Javadoc)
   * @see com.sap.core.odata.api.edm.provider.Property#setAnnotationAttributes(java.util.List)
   */
  @Override
  public SimpleProperty setAnnotationAttributes(final List<AnnotationAttribute> annotationAttributes) {
    super.setAnnotationAttributes(annotationAttributes);
    return this;
  }

  /* (non-Javadoc)
   * @see com.sap.core.odata.api.edm.provider.Property#setAnnotationElements(java.util.List)
   */
  @Override
  public SimpleProperty setAnnotationElements(final List<AnnotationElement> annotationElements) {
    super.setAnnotationElements(annotationElements);
    return this;
  }
}
