/*******************************************************************************
 * This file is part of OpenNMS(R).
 *
 * Copyright (C) 2012 The OpenNMS Group, Inc.
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
 *     OpenNMS(R) Licensing &lt;license@opennms.org&gt;
 *     http://www.opennms.org/
 *     http://www.opennms.com/
 *******************************************************************************/

@XmlSchema(
    namespace="http://xmlns.opennms.org/xsd/config/snmp",
    elementFormDefault=javax.xml.bind.annotation.XmlNsForm.QUALIFIED,
    xmlns={
        @XmlNs(prefix="", namespaceURI="http://xmlns.opennms.org/xsd/config/snmp")
    }
)
package org.opennms.netmgt.config.snmp;
import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlSchema;
