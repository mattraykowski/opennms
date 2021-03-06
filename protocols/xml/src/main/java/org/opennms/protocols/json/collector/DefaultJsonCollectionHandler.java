/*******************************************************************************
 * This file is part of OpenNMS(R).
 *
 * Copyright (C) 2011-2012 The OpenNMS Group, Inc.
 * OpenNMS(R) is Copyright (C) 1999-2012 The OpenNMS Group, Inc.
 *
 * OpenNMS(R) is a registered trademark of The OpenNMS Group, Inc.
 *
 * OpenNMS(R) is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published
 * by the Free Software Foundation, either version 3 of the License,
 * or (at your option) any later version.
 *
 * OpenNMS(R) is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with OpenNMS(R).  If not, see:
 *      http://www.gnu.org/licenses/
 *
 * For more information contact:
 *     OpenNMS(R) Licensing <license@opennms.org>
 *     http://www.opennms.org/
 *     http://www.opennms.com/
 *******************************************************************************/

package org.opennms.protocols.json.collector;

import net.sf.json.JSONObject;

import org.opennms.netmgt.collection.api.AttributeGroupType;
import org.opennms.netmgt.collection.api.CollectionAgent;
import org.opennms.protocols.xml.collector.XmlCollectionResource;
import org.opennms.protocols.xml.collector.XmlCollectionSet;
import org.opennms.protocols.xml.config.Request;
import org.opennms.protocols.xml.config.XmlSource;

/**
 * The default implementation of the interface XmlCollectionHandler based on AbstractJsonCollectionHandler.
 * 
 * @author <a href="mailto:ronald.roskens@gmail.com">Ronald Roskens</a>
 * @author <a href="mailto:agalue@opennms.org">Alejandro Galue</a>
 */
public class DefaultJsonCollectionHandler extends AbstractJsonCollectionHandler {

    /* (non-Javadoc)
     * @see org.opennms.protocols.xml.collector.AbstractXmlCollectionHandler#fillCollectionSet(java.lang.String, org.opennms.protocols.xml.config.Request, org.opennms.netmgt.collection.api.CollectionAgent, org.opennms.protocols.xml.collector.XmlCollectionSet, org.opennms.protocols.xml.config.XmlSource)
     */
    @Override
    protected void fillCollectionSet(String urlString, Request request, CollectionAgent agent, XmlCollectionSet collectionSet, XmlSource source) throws Exception {
        JSONObject json = getJSONObject(urlString, request);
        fillCollectionSet(agent, collectionSet, source, json);
    }

    /* (non-Javadoc)
     * @see org.opennms.protocols.xml.collector.AbstractXmlCollectionHandler#processXmlResource(org.opennms.protocols.xml.collector.XmlCollectionResource, org.opennms.netmgt.config.collector.AttributeGroupType)
     */
    protected void processXmlResource(XmlCollectionResource collectionResource, AttributeGroupType attribGroupType) {}

}
