import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;

@ManagedBean
@RequestScoped
public class HomeController {

    public void goToHome() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("home.xhtml");
    }

    public void goToAccounts() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("accounts.xhtml");
    }

    public void goToLoans() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("loans.xhtml");
    }

    public void goToTransfers() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("transfers.xhtml");
    }

    public void goToProfile() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("profile.xhtml");
    }
}
