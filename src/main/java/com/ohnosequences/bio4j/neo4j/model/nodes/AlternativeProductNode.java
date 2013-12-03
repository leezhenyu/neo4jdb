/*
 * Copyright (C) 2010-2011  "Bio4j"
 *
 * This file is part of Bio4j
 *
 * Bio4j is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

package com.ohnosequences.bio4j.neo4j.model.nodes;

import com.ohnosequences.bio4j.neo4j.model.relationships.IsoformEventGeneratorRel;
import com.ohnosequences.neo4j.BasicEntity;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;

/**
 * Protein alternative products
 * @author Pablo Pareja Tobes <ppareja@era7.com>
 */
public class AlternativeProductNode extends BasicEntity{

    public static final String NODE_TYPE = AlternativeProductNode.class.getCanonicalName();
    public static final String ALTERNATIVE_PRODUCT_NAME_INDEX = "alternative_product_name_index";

    public static final String NAME_PROPERTY = "alternative_product_name";


    public AlternativeProductNode(Node n){
        super(n);
    }


    public String getName(){    return String.valueOf(node.getProperty(NAME_PROPERTY));}


    public void setName(String value){  node.setProperty(NAME_PROPERTY, value);}


    public List<IsoformNode> getIsoforms(){
        List<IsoformNode> list = new LinkedList<IsoformNode>();
        Iterator<Relationship> iterator = node.getRelationships(new IsoformEventGeneratorRel(null), Direction.INCOMING).iterator();
        while(iterator.hasNext()){
            list.add(new IsoformNode(iterator.next().getStartNode()));
        }
        return list;
    }
    
    @Override
    public int hashCode(){
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof AlternativeProductNode){
            AlternativeProductNode other = (AlternativeProductNode) obj;
            return this.node.equals(other.node);
        }else{
            return false;
        }
    }

    @Override
    public String toString(){
        return "name = " + getName();
    }

}
