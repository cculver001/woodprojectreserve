
package com.woodprojectreserve.model.domian;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.woodprojectreserve.model.buisness.ReservationManager;

/** <h1>Reservation</h1>
 * <br>
 * <code>Reservation</code> object that defines a <code>Reservation</code> within WoodProjectReserve application. 
 * <br><br>
 * 
 * @version - 9.19.2021
 * @author Christopher Culver
 */
@ManagedBean
@SessionScoped
public class Reservation implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String userId;
	private String name;
	private String material;
	private String woodMain;
	private String woodSecondary;
	private String finishType;
	private String completionDate;
	private String detail;
	private boolean active;
	private String comment;
	
	/** <h1>Reservation</h1>
	 * 
	 * <br>
	 * Default constructor for the <code>Reservation</code> object
	 * 
	 */
	public Reservation() {
	}

	/** <h1>Reservation</h1>
	 * 
	 * <br>
	 * Constructor, builds complete <code>Reservation</code> Object
	 * <br><br>
	 * @param id - ID of the <code>Reservation</code> object
	 * @param name - name of <code>Reservation</code>
	 * @param material - material type to be used
	 * @param woodMain - wood type (main)
	 * @param woodSecondary - wood type (secondary)
	 * @param finishType - finish type to be used
	 * @param completionDate - completion date requested
	 * @param detail - details about the reservation
	 * @param active - describes if the current reservation is activated
	 * @param comment - comments about the progress of the reservation
	 */
	public Reservation(
			int id,
			String userId,
			String name, 
			String material, 
			String woodMain, 
			String woodSecondary, 
			String finishType,
			String completionDate, 
			String detail, 
			boolean active, 
			String comment) {
		this.id = id;
		this.userId = userId;
		this.name = name;
		this.material = material;
		this.woodMain = woodMain;
		this.woodSecondary = woodSecondary;
		this.finishType = finishType;
		this.completionDate = completionDate;
		this.detail = detail;
		this.active = active;
		this.comment = comment;
	}

	/** <h1>Reservation</h1>
	 * 
	 * <br>
	 * Constructor, builds <code>Reservation</code> object; defaults status to false and initializes comment to null
	 * <br><br>
	 * @param id - ID of the <code>Reservation</code> object
	 * @param name - name of <code>Reservation</code>
	 * @param material - material type to be used
	 * @param woodMain - wood type (main)
	 * @param woodSecondary - wood type (secondary)
	 * @param finishType - finish type to be used
	 * @param completionDate - completion date requested
	 * @param detail - details about the reservation
	 */
	public Reservation(
			int id,
			String userId,
			String name, 
			String material, 
			String woodMain, 
			String woodSecondary, 
			String finishType,
			String completionDate, 
			String detail) {
		this.id = id;
		this.userId = userId;
		this.name = name;
		this.material = material;
		this.woodMain = woodMain;
		this.woodSecondary = woodSecondary;
		this.finishType = finishType;
		this.completionDate = completionDate;
		this.detail = detail;
		this.active = false;
		this.comment = null;
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/** <h1>getName</h1>
	 * <br>
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/** <h1>setName</h1>
	 * <br>
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/** <h1>getMaterial</h1>
	 * <br>
	 * @return the material
	 */
	public String getMaterial() {
		return material;
	}

	/** <h1>setMaterial</h1>
	 * <br>
	 * @param material the material to set
	 */
	public void setMaterial(String material) {
		this.material = material;
	}

	/** <h1>getWoodMain</h1>
	 * <br>
	 * @return the woodMain
	 */
	public String getWoodMain() {
		return woodMain;
	}

	/** <h1>setWoodMain</h1>
	 * <br>
	 * @param woodMain the woodMain to set
	 */
	public void setWoodMain(String woodMain) {
		this.woodMain = woodMain;
	}

	/** <h1>getWoodSecondary</h1>
	 * <br>
	 * @return the woodSecondary
	 */
	public String getWoodSecondary() {
		return woodSecondary;
	}

	/** <h1>setWoodSecondary</h1>
	 * <br>
	 * @param woodSecondary the woodSecondary to set
	 */
	public void setWoodSecondary(String woodSecondary) {
		this.woodSecondary = woodSecondary;
	}

	/** <h1>getFinishType</h1>
	 * <br>
	 * @return the finishType
	 */
	public String getFinishType() {
		return finishType;
	}

	/** <h1>setFinishType</h1>
	 * <br>
	 * @param finishType the finishType to set
	 */
	public void setFinishType(String finishType) {
		this.finishType = finishType;
	}

	/** <h1>getCompletionDate</h1>
	 * <br>
	 * @return the completionDate
	 */
	public String getCompletionDate() {
		return completionDate;
	}

	/** <h1>setCompletionDate</h1>
	 * <br>
	 * @param completionDate the completionDate to set
	 */
	public void setCompletionDate(String completionDate) {
		this.completionDate = completionDate;
	}

	/** <h1>getDetail</h1>
	 * <br>
	 * @return the detail
	 */
	public String getDetail() {
		return detail;
	}

	/** <h1>setDetail</h1>
	 * <br>
	 * @param detail the detail to set
	 */
	public void setDetail(String detail) {
		this.detail = detail;
	}

	/** <h1>isStatus</h1>
	 * <br>
	 * @return the status
	 */
	public boolean isActive() {
		return active;
	}

	/** <h1>setStatus</h1>
	 * <br>
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/** <h1>getComment</h1>
	 * <br>
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/** <h1>setComment</h1>
	 * <br>
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	/** <h1>authenticate</h1>
	 * <br>
	 * Authenticates <code>Customer</code> object
	 * <br>
	 * <br><br>
	 * 
	 * @return the view
	 */
	public String authenticate() {
		
		this.userId = "cutomer";
		this.active = false;
		
		if (ReservationManager.validateReservation(this)) {
			return "reservation-complete";
		} else {
			return "error-page";
		}
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (active ? 1231 : 1237);
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + ((completionDate == null) ? 0 : completionDate.hashCode());
		result = prime * result + ((detail == null) ? 0 : detail.hashCode());
		result = prime * result + ((finishType == null) ? 0 : finishType.hashCode());
		result = prime * result + id;
		result = prime * result + ((material == null) ? 0 : material.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((woodMain == null) ? 0 : woodMain.hashCode());
		result = prime * result + ((woodSecondary == null) ? 0 : woodSecondary.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Reservation)) {
			return false;
		}
		Reservation other = (Reservation) obj;
		if (active != other.active) {
			return false;
		}
		if (comment == null) {
			if (other.comment != null) {
				return false;
			}
		} else if (!comment.equals(other.comment)) {
			return false;
		}
		if (completionDate == null) {
			if (other.completionDate != null) {
				return false;
			}
		} else if (!completionDate.equals(other.completionDate)) {
			return false;
		}
		if (detail == null) {
			if (other.detail != null) {
				return false;
			}
		} else if (!detail.equals(other.detail)) {
			return false;
		}
		if (finishType == null) {
			if (other.finishType != null) {
				return false;
			}
		} else if (!finishType.equals(other.finishType)) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		if (material == null) {
			if (other.material != null) {
				return false;
			}
		} else if (!material.equals(other.material)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (userId == null) {
			if (other.userId != null) {
				return false;
			}
		} else if (!userId.equals(other.userId)) {
			return false;
		}
		if (woodMain == null) {
			if (other.woodMain != null) {
				return false;
			}
		} else if (!woodMain.equals(other.woodMain)) {
			return false;
		}
		if (woodSecondary == null) {
			if (other.woodSecondary != null) {
				return false;
			}
		} else if (!woodSecondary.equals(other.woodSecondary)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Reservation [id=");
		builder.append(id);
		builder.append(", ");
		if (userId != null) {
			builder.append("userId=");
			builder.append(userId);
			builder.append(", ");
		}
		if (name != null) {
			builder.append("name=");
			builder.append(name);
			builder.append(", ");
		}
		if (material != null) {
			builder.append("material=");
			builder.append(material);
			builder.append(", ");
		}
		if (woodMain != null) {
			builder.append("woodMain=");
			builder.append(woodMain);
			builder.append(", ");
		}
		if (woodSecondary != null) {
			builder.append("woodSecondary=");
			builder.append(woodSecondary);
			builder.append(", ");
		}
		if (finishType != null) {
			builder.append("finishType=");
			builder.append(finishType);
			builder.append(", ");
		}
		if (completionDate != null) {
			builder.append("completionDate=");
			builder.append(completionDate);
			builder.append(", ");
		}
		if (detail != null) {
			builder.append("detail=");
			builder.append(detail);
			builder.append(", ");
		}
		builder.append("active=");
		builder.append(active);
		builder.append(", ");
		if (comment != null) {
			builder.append("comment=");
			builder.append(comment);
		}
		builder.append("]");
		return builder.toString();
	}
	
}