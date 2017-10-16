package br.com.ricardosander.meupetshop.dao;

import br.com.ricardosander.meupetshop.criteria.PetCriteria;
import br.com.ricardosander.meupetshop.database.Database;
import br.com.ricardosander.meupetshop.model.Owner;
import br.com.ricardosander.meupetshop.model.User;

import java.beans.PropertyVetoException;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Implementação MySQL de DAO para Owner.
 */
public class MySQLOwnerDAO implements OwnerDAO {

    @Override
    public int count(User user, PetCriteria petCriteria) {

        String sql = new StringBuilder()
                .append(" SELECT COUNT(1) AS TOTAL ")
                .append(" FROM cliente C ")
                .append(" WHERE C.usuario = ? ")
                .toString();

        try (
                Connection connection = new Database().getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {

            preparedStatement.setLong(1, user.getId());

            if (preparedStatement.execute()) {

                ResultSet resultSet = preparedStatement.getResultSet();
                if (resultSet.next()) {
                    return resultSet.getInt("TOTAL");
                }
            }

        } catch (SQLException | PropertyVetoException e) {
            System.out.println("Erro ao conectar no banco de dados ou realizar query.");
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public List<Owner> find(User user, PetCriteria petCriteria) {

        List<Owner> owners = new LinkedList<>();

        StringBuilder sqlBuilder = new StringBuilder()
                .append(" SELECT ")
                .append(" ID, ")
                .append(" NOME, ")
                .append(" NOME_SECUNDARIO, ")
                .append(" ENDERECO, ")
                .append(" BAIRRO, ")
                .append(" TELEFONE, ")
                .append(" TELEFONE2, ")
                .append(" TELEFONE3, ")
                .append(" TELEFONE4, ")
                .append(" TELEFONE5, ")
                .append(" OBSERVACAO, ")
                .append(" SALDO_DEVEDOR ")
                .append(" FROM cliente C ")
                .append(" WHERE C.usuario = ? ");

        if (petCriteria.getLimit() != 0) {
            sqlBuilder.append(" LIMIT ? OFFSET ? ");
        }

        String sql = sqlBuilder.toString();

        try (
                Connection connection = new Database().getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {

            preparedStatement.setLong(1, user.getId());

            if (petCriteria.getLimit() != 0) {
                preparedStatement.setInt(2, petCriteria.getLimit());
                preparedStatement.setInt(3, petCriteria.getOffset());
            }

            if (preparedStatement.execute()) {

                Owner owner;
                ResultSet resultSet = preparedStatement.getResultSet();
                while (resultSet.next()) {

                    owner = new Owner(resultSet.getLong("ID"), resultSet.getString("NOME"));
                    owner.setSecondaryName(resultSet.getString("NOME_SECUNDARIO"));
                    owner.setAddress(resultSet.getString("ENDERECO"));
                    owner.setDistrict(resultSet.getString("BAIRRO"));
                    owner.setPhone(resultSet.getString("TELEFONE"));
                    owner.setPhone2(resultSet.getString("TELEFONE2"));
                    owner.setPhone3(resultSet.getString("TELEFONE3"));
                    owner.setPhone4(resultSet.getString("TELEFONE4"));
                    owner.setPhone5(resultSet.getString("TELEFONE5"));
                    owner.setComments(resultSet.getString("OBSERVACAO"));
                    owner.setDebtor(resultSet.getDouble("SALDO_DEVEDOR"));
                    owner.setUser(user);

                    owners.add(owner);
                }
            }

        } catch (SQLException | PropertyVetoException e) {
            System.out.println("Erro ao conectar no banco de dados ou realizar query.");
            e.printStackTrace();
        }

        return owners;
    }

    @Override
    public Owner find(User user, long id) {

        String sql = new StringBuilder()
                .append(" SELECT ")
                .append(" ID, ")
                .append(" NOME, ")
                .append(" NOME_SECUNDARIO, ")
                .append(" ENDERECO, ")
                .append(" BAIRRO, ")
                .append(" TELEFONE, ")
                .append(" TELEFONE2, ")
                .append(" TELEFONE3, ")
                .append(" TELEFONE4, ")
                .append(" TELEFONE5, ")
                .append(" OBSERVACAO, ")
                .append(" SALDO_DEVEDOR ")
                .append(" FROM cliente C ")
                .append(" WHERE C.usuario = ? AND C.ID = ? ")
                .toString();

        try (
                Connection connection = new Database().getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {

            preparedStatement.setLong(1, user.getId());
            preparedStatement.setLong(2, id);

            if (preparedStatement.execute()) {

                Owner owner;
                ResultSet resultSet = preparedStatement.getResultSet();
                if (resultSet.next()) {

                    owner = new Owner(resultSet.getLong("ID"), resultSet.getString("NOME"));
                    owner.setSecondaryName(resultSet.getString("NOME_SECUNDARIO"));
                    owner.setAddress(resultSet.getString("ENDERECO"));
                    owner.setDistrict(resultSet.getString("BAIRRO"));
                    owner.setPhone(resultSet.getString("TELEFONE"));
                    owner.setPhone2(resultSet.getString("TELEFONE2"));
                    owner.setPhone3(resultSet.getString("TELEFONE3"));
                    owner.setPhone4(resultSet.getString("TELEFONE4"));
                    owner.setPhone5(resultSet.getString("TELEFONE5"));
                    owner.setComments(resultSet.getString("OBSERVACAO"));
                    owner.setDebtor(resultSet.getDouble("SALDO_DEVEDOR"));
                    owner.setUser(user);

                    return owner;
                }
            }

        } catch (SQLException | PropertyVetoException e) {
            System.out.println("Erro ao conectar no banco de dados ou realizar query.");
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean insert(Owner owner) {

        String sql = new StringBuilder()
                .append(" insert into cliente ")
                .append(" (nome, nome_secundario, endereco, bairro, telefone, telefone2, telefone3, telefone4, ")
                .append(" telefone5, observacao, saldo_devedor, usuario) ")
                .append(" values ")
                .append(" (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ")
                .toString();

        try (
                Connection connection = new Database().getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ) {

            int index = 1;
            preparedStatement.setString(index++, owner.getName());
            preparedStatement.setString(index++, owner.getSecondaryName());
            preparedStatement.setString(index++, owner.getAddress());
            preparedStatement.setString(index++, owner.getDistrict());
            preparedStatement.setString(index++, owner.getPhone());
            preparedStatement.setString(index++, owner.getPhone2());
            preparedStatement.setString(index++, owner.getPhone3());
            preparedStatement.setString(index++, owner.getPhone4());
            preparedStatement.setString(index++, owner.getPhone5());
            preparedStatement.setString(index++, owner.getComments());
            preparedStatement.setDouble(index++, owner.getDebtor());
            preparedStatement.setLong(index++, owner.getUser().getId());

            if (preparedStatement.executeUpdate() > 0) {

                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    owner.setId(generatedKeys.getLong(1));
                    return true;
                }
            }

        } catch (SQLException | PropertyVetoException e) {
            System.out.println("Erro ao conectar no banco de dados ou realizar query.");
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean remove(Owner owner) {

        String sql = " delete from cliente where id = ? ";

        try (
                Connection connection = new Database().getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {

            preparedStatement.setLong(1, owner.getId());

            return preparedStatement.executeUpdate() > 0;

        } catch (SQLException | PropertyVetoException e) {
            System.out.println("Erro ao conectar no banco de dados ou realizar query.");
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean update(Owner owner) {

        String fields = String.join(", ", new String[]{
                "nome = ?",
                "nome_secundario = ?",
                "endereco = ?",
                "bairro = ?",
                "telefone = ?",
                "telefone2 = ?",
                "telefone3 = ?",
                "telefone4 = ?",
                "telefone5 = ?",
                "observacao = ?",
                "saldo_devedor = ?",
                "usuario = ?",
        });

        String sql = " update cliente set " + fields + " where id = ?";

        try (
                Connection connection = new Database().getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {

            int index = 1;
            preparedStatement.setString(index++, owner.getName());
            preparedStatement.setString(index++, owner.getSecondaryName());
            preparedStatement.setString(index++, owner.getAddress());
            preparedStatement.setString(index++, owner.getDistrict());
            preparedStatement.setString(index++, owner.getPhone());
            preparedStatement.setString(index++, owner.getPhone2());
            preparedStatement.setString(index++, owner.getPhone3());
            preparedStatement.setString(index++, owner.getPhone4());
            preparedStatement.setString(index++, owner.getPhone5());
            preparedStatement.setString(index++, owner.getComments());
            preparedStatement.setDouble(index++, owner.getDebtor());
            preparedStatement.setLong(index++, owner.getUser().getId());
            preparedStatement.setLong(index++, owner.getId());

            return preparedStatement.executeUpdate() > 0;

        } catch (SQLException | PropertyVetoException e) {
            System.out.println("Erro ao conectar no banco de dados ou realizar query.");
            e.printStackTrace();
        }

        return false;
    }

}
