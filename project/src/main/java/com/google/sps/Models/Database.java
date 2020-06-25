// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.sps.models;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;  
import java.util.Date;
import java.util.ArrayList;
import com.google.gson.*;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.PreparedQuery.TooManyResultsException;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.CompositeFilter;
import com.google.appengine.api.datastore.Query.CompositeFilterOperator;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;
import com.google.appengine.api.datastore.Query.SortDirection;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

public class Database {
  // public static List<int> getUserDocumentIDs(int id) {
  //   getDatabase();
  //   //return list of document ids
  // }

  public static User logInUser(String email, String nickname) {
    Query query = new Query("User").addFilter("email", Query.FilterOperator.EQUAL, email);
    Entity userEntity = getDatastore().prepare(query).asSingleEntity();

    if(userEntity != null) {
      return new User(email, nickname, userEntity.getKey().getId());
    } else {
      return createUser(email, nickname);
    }
  }

  public static User getUserByEmail(String email) {
    Query query = new Query("User").addFilter("email", Query.FilterOperator.EQUAL, email);
    Entity userEntity = getDatastore().prepare(query).asSingleEntity();

    String nickname = (String) userEntity.getProperty("nickname");
    long userID = userEntity.getKey().getId();

    if(userEntity == null) {
      return null;
    }

    return new User(email, nickname, userID);
  }

  public static User getUserByID(long userID) {
    Query query = new Query("User").addFilter("__key__", Query.FilterOperator.EQUAL, KeyFactory.createKey("User", userID));
    Entity userEntity = getDatastore().prepare(query).asSingleEntity();

    String email = (String) userEntity.getProperty("email");
    String nickname = (String) userEntity.getProperty("nickname");

    if(userEntity == null) {
      return null;
    }

    return new User(email, nickname, userID);
  }

  private static DatastoreService getDatastore() {
    return DatastoreServiceFactory.getDatastoreService();
  }

  private static User createUser(String email, String nickname) {
    Entity userEntity = new Entity("User");
    ArrayList<String> documents = new ArrayList<String>();

    userEntity.setProperty("email", email);
    userEntity.setProperty("nickname", nickname);
    userEntity.setProperty("documents", documents);
    getDatastore().put(userEntity);
    long userID = userEntity.getKey().getId();

    return new User(email, nickname, userID);
  }

  private static Document createDocument(String name, String language, String hash, long userID) {
      Entity docEntity = new Entity("Document");
      
      docEntity.setProperty("name", name);
      docEntity.setProperty("language", language);
      docEntity.setProperty("hash", hash);
      getDatastore().put(userEntity);

      return new Document(name, language, hash, Arr)
  }
}