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

package com.bio4j.neo4jdb.model.relationships.citation.onarticle;

import com.bio4j.neo4jdb.model.nodes.ProteinNode;
import com.bio4j.neo4jdb.model.nodes.citation.OnlineArticleNode;
import com.bio4j.neo4jdb.BasicRelationship;
import org.neo4j.graphdb.Relationship;

/**
 * Proteins that an online articles references
 * @author Pablo Pareja Tobes <ppareja@era7.com>
 */
public class OnlineArticleProteinCitationRel extends BasicRelationship{

    public static final String NAME = "ONLINE_ARTICLE_PROTEIN_CITATION";

    public OnlineArticleProteinCitationRel(Relationship rel){
        super(rel);
    }
    
    public OnlineArticleNode getOnlineArticle(){
        return new OnlineArticleNode(getStartNode());
    }
    
    public ProteinNode getProtein(){
        return new ProteinNode(getEndNode());
    }

    @Override
    public String name() {
        return NAME;
    }

}
