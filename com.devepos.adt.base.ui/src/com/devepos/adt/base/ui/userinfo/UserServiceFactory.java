package com.devepos.adt.base.ui.userinfo;

import com.devepos.adt.base.ui.internal.userinfo.UserService;
import com.sap.adt.tools.core.system.IUser;

/**
 * Factory for creating/accessing User Services
 * 
 * @author stockbal
 */
@SuppressWarnings("restriction")
public class UserServiceFactory {

	/**
	 * Creates and returns instance of the User service
	 * 
	 * @return instance of the User service
	 */
	public static IUserService createUserService() {
		return new UserService();
	}

	/**
	 * Creates new User
	 * 
	 * @param  id   id of a user
	 * @param  text description/text of a user
	 * @return      instance of {@link IUser}
	 */
	public static IUser createUser(final String id, final String text) {
		return new User(id, text);
	}

	/*
	 * Copy of ADT User implementation to set initial selections.
	 */
	private static class User implements IUser {
		private final String id;
		private final String text;

		public User(final String id, final String text) {
			this.id = id;
			this.text = text;
		}

		@Override
		public String getId() {
			return this.id;
		}

		@Override
		public int compareTo(final IUser o) {
			return this.id.compareTo(o.getId());
		}

		@Override
		public int hashCode() {
			int result = 1;
			result = 31 * result + this.id.hashCode();
			return result;
		}

		@Override
		public boolean equals(final Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (this.getClass() != obj.getClass()) {
				return false;
			}
			final User other = (User) obj;
			if (!this.id.equals(other.id)) {
				return false;
			}
			return true;
		}

		@Override
		public String toString() {
			return this.id;
		}

		@Override
		public String getText() {
			return this.text;
		}

	}

}
