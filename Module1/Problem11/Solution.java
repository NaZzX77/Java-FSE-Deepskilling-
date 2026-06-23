interface CustomerRepository {
    String findCustomerById(int customerId);
}

class CustomerRepositoryImpl implements CustomerRepository {
    public String findCustomerById(int customerId) {
        if (customerId == 101) {
            return "Rahul";
        }
        return "Customer not found";
    }
}

class CustomerService {
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public String getCustomer(int customerId) {
        return customerRepository.findCustomerById(customerId);
    }
}

public class Solution {
    public static void main(String[] args) {
        CustomerRepository customerRepository = new CustomerRepositoryImpl();
        CustomerService customerService = new CustomerService(customerRepository);

        System.out.println(customerService.getCustomer(101));
    }
}
