/**********************************************************************************
 * $URL:  $
 * $Id:  $
 ***********************************************************************************
 *
 * Copyright (c) 2006, 2007 The Sakai Foundation.
 * 
 * Licensed under the Educational Community License, Version 1.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at
 * 
 *      http://www.opensource.org/licenses/ecl1.php
 * 
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and 
 * limitations under the License.
 *
 **********************************************************************************/

package org.sakaiproject.content.types;

import java.util.EnumMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import org.sakaiproject.component.cover.ComponentManager;
import org.sakaiproject.content.api.ContentEntity;
import org.sakaiproject.content.api.InteractionAction;
import org.sakaiproject.content.api.ResourceToolAction;
import org.sakaiproject.content.api.ResourceToolActionPipe;
import org.sakaiproject.content.api.ServiceLevelAction;
import org.sakaiproject.content.api.ResourceToolAction.ActionType;
import org.sakaiproject.content.util.BaseResourceType;
import org.sakaiproject.entity.api.Reference;
import org.sakaiproject.user.api.User;
import org.sakaiproject.user.api.UserDirectoryService;
import org.sakaiproject.util.ResourceLoader;

public class UrlResourceType extends BaseResourceType 
{
	/** Resource bundle using current language locale */
	private static ResourceLoader rb = new ResourceLoader("types");
	
	protected EnumMap<ResourceToolAction.ActionType, List<ResourceToolAction>> actionMap = new EnumMap<ResourceToolAction.ActionType, List<ResourceToolAction>>(ResourceToolAction.ActionType.class);

	protected Map<String, ResourceToolAction> actions = new Hashtable<String, ResourceToolAction>();	
	protected UserDirectoryService userDirectoryService;
	
	protected String typeId = "Url";
	protected String helperId = "sakai.resource.type.helper";
	
	public class UrlResourceCopyAction implements ServiceLevelAction
	{
		/* (non-Javadoc)
		 * @see org.sakaiproject.content.api.ResourceToolAction#getActionType()
		 */
		public ActionType getActionType()
		{
			return ResourceToolAction.ActionType.COPY;
		}

		public String getId() 
		{
			return ResourceToolAction.COPY;
		}

		public String getLabel() 
		{
			return rb.getString("action.copy");
		}

		public boolean isMultipleItemAction() 
		{
			return true;
		}
		
		public String getTypeId() 
		{
			return typeId;
		}

		/* (non-Javadoc)
		 * @see org.sakaiproject.content.api.ServiceLevelAction#cancelAction(org.sakaiproject.entity.api.Reference)
		 */
		public void cancelAction(Reference reference)
		{
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see org.sakaiproject.content.api.ServiceLevelAction#finalizeAction(org.sakaiproject.entity.api.Reference)
		 */
		public void finalizeAction(Reference reference)
		{
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see org.sakaiproject.content.api.ServiceLevelAction#initializeAction(org.sakaiproject.entity.api.Reference)
		 */
		public void initializeAction(Reference reference)
		{
			// TODO Auto-generated method stub
			
		}

	}

	public class UrlResourceCreateAction implements InteractionAction
	{
		public String initializeAction(Reference reference) 
		{
			return null;
		}

		public void cancelAction(Reference reference, String initializationId) 
		{
			// TODO Auto-generated method stub
			
		}

		public void finalizeAction(Reference reference, String initializationId) 
		{
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see org.sakaiproject.content.api.ResourceToolAction#getActionType()
		 */
		public ActionType getActionType()
		{
			return ResourceToolAction.ActionType.CREATE;
		}

		public String getId() 
		{
			return ResourceToolAction.CREATE;
		}

		public String getLabel() 
		{
			return rb.getString("create.url"); 
		}

		public String getTypeId() 
		{
			return typeId;
		}

		public String getHelperId() 
		{
			return helperId;
		}

		public List getRequiredPropertyKeys() 
		{
			return null;
		}

	}

	public class UrlResourceDeleteAction implements ServiceLevelAction
	{
		/* (non-Javadoc)
		 * @see org.sakaiproject.content.api.ResourceToolAction#getActionType()
		 */
		public ActionType getActionType()
		{
			return ResourceToolAction.ActionType.DELETE;
		}

		public String getId() 
		{
			return ResourceToolAction.DELETE;
		}

		public String getLabel() 
		{
			return rb.getString("action.delete"); 
		}

		public boolean isMultipleItemAction() 
		{
			return true;
		}
		
		public String getTypeId() 
		{
			return typeId;
		}

		/* (non-Javadoc)
		 * @see org.sakaiproject.content.api.ServiceLevelAction#cancelAction(org.sakaiproject.entity.api.Reference)
		 */
		public void cancelAction(Reference reference)
		{
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see org.sakaiproject.content.api.ServiceLevelAction#finalizeAction(org.sakaiproject.entity.api.Reference)
		 */
		public void finalizeAction(Reference reference)
		{
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see org.sakaiproject.content.api.ServiceLevelAction#initializeAction(org.sakaiproject.entity.api.Reference)
		 */
		public void initializeAction(Reference reference)
		{
			// TODO Auto-generated method stub
			
		}

	}

	public class UrlResourceDuplicateAction implements ServiceLevelAction
	{
		/* (non-Javadoc)
		 * @see org.sakaiproject.content.api.ResourceToolAction#getActionType()
		 */
		public ActionType getActionType()
		{
			return ResourceToolAction.ActionType.DUPLICATE;
		}

		public String getId() 
		{
			return ResourceToolAction.DUPLICATE;
		}

		public String getLabel() 
		{
			return rb.getString("action.duplicate"); 
		}

		public boolean isMultipleItemAction() 
		{
			// TODO Auto-generated method stub
			return false;
		}
		
		public String getTypeId() 
		{
			return typeId;
		}

		/* (non-Javadoc)
		 * @see org.sakaiproject.content.api.ServiceLevelAction#cancelAction(org.sakaiproject.entity.api.Reference)
		 */
		public void cancelAction(Reference reference)
		{
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see org.sakaiproject.content.api.ServiceLevelAction#finalizeAction(org.sakaiproject.entity.api.Reference)
		 */
		public void finalizeAction(Reference reference)
		{
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see org.sakaiproject.content.api.ServiceLevelAction#initializeAction(org.sakaiproject.entity.api.Reference)
		 */
		public void initializeAction(Reference reference)
		{
			// TODO Auto-generated method stub
			
		}

	}

	public class UrlResourceMoveAction implements ServiceLevelAction
	{
		/* (non-Javadoc)
		 * @see org.sakaiproject.content.api.ResourceToolAction#getActionType()
		 */
		public ActionType getActionType()
		{
			return ResourceToolAction.ActionType.MOVE;
		}

		public String getId() 
		{
			return ResourceToolAction.MOVE;
		}

		public String getLabel() 
		{
			return rb.getString("action.move"); 
		}

		public boolean isMultipleItemAction() 
		{
			// TODO Auto-generated method stub
			return true;
		}
		
		public String getTypeId() 
		{
			return typeId;
		}

		/* (non-Javadoc)
		 * @see org.sakaiproject.content.api.ServiceLevelAction#cancelAction(org.sakaiproject.entity.api.Reference)
		 */
		public void cancelAction(Reference reference)
		{
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see org.sakaiproject.content.api.ServiceLevelAction#finalizeAction(org.sakaiproject.entity.api.Reference)
		 */
		public void finalizeAction(Reference reference)
		{
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see org.sakaiproject.content.api.ServiceLevelAction#initializeAction(org.sakaiproject.entity.api.Reference)
		 */
		public void initializeAction(Reference reference)
		{
			// TODO Auto-generated method stub
			
		}

	}

	public class UrlResourceReviseAction implements InteractionAction
	{
		public String initializeAction(Reference reference) 
		{
			return null;
		}

		public void cancelAction(Reference reference, String initializationId) 
		{
			// TODO Auto-generated method stub
			
		}

		public void finalizeAction(Reference reference, String initializationId) 
		{
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see org.sakaiproject.content.api.ResourceToolAction#getActionType()
		 */
		public ActionType getActionType()
		{
			return ResourceToolAction.ActionType.REVISE_CONTENT;
		}

		public String getId() 
		{
			return ResourceToolAction.REVISE_CONTENT;
		}

		public String getLabel() 
		{
			return rb.getString("action.revise"); 
		}
		
		public String getTypeId() 
		{
			return typeId;
		}

		public String getHelperId() 
		{
			return helperId;
		}

		public List getRequiredPropertyKeys() 
		{
			return null;
		}

	}
	
	public class UrlResourceAccessAction implements InteractionAction
	{
		public String initializeAction(Reference reference) 
		{
			return null;
		}

		public void cancelAction(Reference reference, String initializationId) 
		{
			// TODO Auto-generated method stub
			
		}

		public void finalizeAction(Reference reference, String initializationId) 
		{
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see org.sakaiproject.content.api.ResourceToolAction#getActionType()
		 */
		public ActionType getActionType()
		{
			return ResourceToolAction.ActionType.VIEW_CONTENT;
		}

		public String getId() 
		{
			return ResourceToolAction.ACCESS_CONTENT;
		}

		public String getLabel() 
		{
			return rb.getString("action.access"); 
		}
		
		public String getTypeId() 
		{
			return typeId;
		}

		public String getHelperId() 
		{
			return helperId;
		}

		public List getRequiredPropertyKeys() 
		{
			return null;
		}

	}
	
	public UrlResourceType()
	{
		this.userDirectoryService = (UserDirectoryService) ComponentManager.get("org.sakaiproject.user.api.UserDirectoryService");
		
		actions.put(ResourceToolAction.CREATE, new UrlResourceCreateAction());
		actions.put(ResourceToolAction.ACCESS_CONTENT, new UrlResourceAccessAction());
		actions.put(ResourceToolAction.REVISE_CONTENT, new UrlResourceReviseAction());
		actions.put(ResourceToolAction.DUPLICATE, new UrlResourceDuplicateAction());
		actions.put(ResourceToolAction.COPY, new UrlResourceCopyAction());
		actions.put(ResourceToolAction.MOVE, new UrlResourceMoveAction());
		actions.put(ResourceToolAction.DELETE, new UrlResourceDeleteAction());
		
		// initialize actionMap with an empty List for each ActionType
		for(ResourceToolAction.ActionType type : ResourceToolAction.ActionType.values())
		{
			actionMap.put(type, new Vector<ResourceToolAction>());
		}
		
		// for each action in actions, add a link in actionMap
		Iterator<String> it = actions.keySet().iterator();
		while(it.hasNext())
		{
			String id = it.next();
			ResourceToolAction action = actions.get(id);
			List<ResourceToolAction> list = actionMap.get(action.getActionType());
			if(list == null)
			{
				list = new Vector<ResourceToolAction>();
				actionMap.put(action.getActionType(), list);
			}
			list.add(action);
		}
		
	}

	public ResourceToolAction getAction(String actionId) 
	{
		return (ResourceToolAction) actions.get(actionId);
	}

	public List getActions(Reference entityRef, Set permissions) 
	{
		// TODO: use entityRef to filter actions
		List rv = new Vector();
		rv.addAll(actions.values());
		return rv;
	}

	public List getActions(Reference entityRef, User user, Set permissions) 
	{
		// TODO: use entityRef and user to filter actions
		List rv = new Vector();
		rv.addAll(actions.values());
		return rv;
	}

	public ResourceToolAction getCreateAction(Reference collectionRef, User user, Set permissions) 
	{
		if(! this.isCreateActionAllowed(collectionRef, user))
		{
			return null;
		}
		return (ResourceToolAction) actions.get(ResourceToolAction.CREATE);
	}
	
	public String getIconLocation() 
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	public String getId() 
	{
		return typeId;
	}

	public String getLabel() 
	{
		return rb.getString("type.url");
	}
	
	public boolean isActionAllowed(String actionId, Reference entityRef, User user) 
	{
		return actions.containsKey(actionId);
	}
	
	public boolean isCreateActionAllowed(Reference collectionRef) 
	{
		return this.isCreateActionAllowed(collectionRef, null);
	}
	
	public boolean isCreateActionAllowed(Reference collectionRef, User user) 
	{
		if(user == null)
		{
			user = userDirectoryService.getCurrentUser();
		}
		return this.isActionAllowed(ResourceToolAction.CREATE, collectionRef, user);
	}
	
	/* (non-Javadoc)
	 * @see org.sakaiproject.content.api.ResourceType#getLocalizedHoverText(org.sakaiproject.entity.api.Reference)
	 */
	public String getLocalizedHoverText(ContentEntity member)
	{
		return rb.getString("type.url");
	}

	/* (non-Javadoc)
	 * @see org.sakaiproject.content.api.ResourceType#getActions(org.sakaiproject.content.api.ResourceType.ActionType)
	 */
	public List<ResourceToolAction> getActions(ActionType type)
	{
		List<ResourceToolAction> list = actionMap.get(type);
		if(list == null)
		{
			list = new Vector<ResourceToolAction>();
			actionMap.put(type, list);
		}
		return new Vector<ResourceToolAction>(list);
	}

	/* (non-Javadoc)
	 * @see org.sakaiproject.content.api.ResourceType#getActions(java.util.List)
	 */
	public List<ResourceToolAction> getActions(List<ActionType> types)
	{
		List<ResourceToolAction> list = new Vector<ResourceToolAction>();
		if(types != null)
		{
			Iterator<ActionType> it = types.iterator();
			while(it.hasNext())
			{
				ActionType type = it.next();
				List<ResourceToolAction> sublist = actionMap.get(type);
				if(sublist == null)
				{
					sublist = new Vector<ResourceToolAction>();
					actionMap.put(type, sublist);
				}
				list.addAll(sublist);
			}
		}
		return list;
	}

}
