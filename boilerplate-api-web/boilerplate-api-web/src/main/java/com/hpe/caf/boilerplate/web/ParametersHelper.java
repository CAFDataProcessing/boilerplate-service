/*
 * Copyright 2017-2020 Micro Focus or one of its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hpe.caf.boilerplate.web;

import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by Michael.McAlynn on 14/12/2015.
 */
public class ParametersHelper {
    public static Integer getIntegerParameterFromRequest(HttpServletRequest request, String parameterName){
        Map pathVariables = (Map) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        String tagIdAsString = (String) pathVariables.get(parameterName);
        if(tagIdAsString==null){
            //no ID provided, generate null ETag
            return null;
        }
        int tagId;
        try{
            tagId = Integer.parseInt(tagIdAsString);
        }
        catch(NumberFormatException e){
            //id not provided in the form of an integer (allow controller to handle null id)
            return null;
        }
        return tagId;
    }
}
